package com.zhzm.utils.aio;

import com.zhzm.antlr.createLexer;
import com.zhzm.antlr.createParser;
import com.zhzm.datacreater.factory.FiledCreaterFactory;
import com.zhzm.datacreater.line.BaseFiledCreater;
import com.zhzm.datacreater.table.TableMaker;
import com.zhzm.datastructure.table.TableStructure;
import com.zhzm.exceptions.TableLoopRelyException;
import com.zhzm.output.*;
import com.zhzm.parser.CreateListenerImpl;
import com.zhzm.utils.InsertPlanMaker;
import com.zhzm.utils.insert.CreateInsertSQLProcess;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.smartboot.socket.MessageProcessor;
import org.smartboot.socket.StateMachineEnum;
import org.smartboot.socket.transport.AioSession;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class ServerProcessor implements MessageProcessor<String> {
    @Override
    public void process(AioSession aioSession, String SQLString) {
        Collection<TableStructure> tablesMetaData = antlrProcess(SQLString);
        Collection<List<TableMaker>> tableMakers = null;
        InsertPlanMaker planMaker = new InsertPlanMaker();
        try {
            if (!planMaker.isClose()) {
                tableMakers = planMaker.transCenter(tablesMetaData);
            }
        } catch (TableLoopRelyException e) {
            System.err.println("分析SQL中存在循环的外键依赖，无法生成数据");
            System.exit(-1);
            return;
        }

        assert tableMakers != null;
        tF output=new NetOutput(aioSession);
        for (Collection<TableMaker> makers : tableMakers) {
            //根据每张表的maker数量建立线程数量，并放到线程池中
            List<BaseFiledCreater> creaters=new LinkedList<>();
            CreateInsertSQLProcess process=new CreateInsertSQLProcess();
            process.setOutput(output);
            for(TableMaker maker:makers){
                creaters.add(FiledCreaterFactory.getFiledCreater(maker));
            }
            try {
                process.createInsertSQL(creaters);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void stateEvent(AioSession session, StateMachineEnum stateMachineEnum, Throwable throwable) {
        MessageProcessor.super.stateEvent(session, stateMachineEnum, throwable);
    }

    private static Collection<TableStructure> antlrProcess(String SQL) {
        CodePointCharStream input = CharStreams.fromString(SQL);
        createLexer lexer = new createLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        createParser parser = new createParser(tokens);
        parser.removeErrorListeners();
//        parser.addErrorListener(new UnsupportedSyntaxListener());
        ParseTree tree = parser.start();

        ParseTreeWalker walker = new ParseTreeWalker();
        CreateListenerImpl listener = new CreateListenerImpl();
        walker.walk(listener, tree);

        return listener.getTableStructures();
    }

}
