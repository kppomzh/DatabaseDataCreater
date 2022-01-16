package com.zhzm.service;

import com.zhzm.antlr.createLexer;
import com.zhzm.antlr.createParser;
import com.zhzm.datacreater.table.TableMaker;
import com.zhzm.datastructure.table.TableStructure;
import com.zhzm.exceptions.TableLoopRelyException;
import com.zhzm.parser.CreateListenerImpl;
import com.zhzm.utils.BaseEnvironment;
import com.zhzm.utils.FileLoader;
import com.zhzm.utils.InsertPlanMaker;
import com.zhzm.utils.StringSpecificationOutput;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class LocalServer {
    private static Scanner scanf = new Scanner(System.in);

    public static void main(String[] args) {
        String filename = null, FileString;
        Double[] linenumber = new Double[0];

        for (int loop = 0; loop < args.length; loop++) {
            switch (args[loop]) {
                case "-f":
                    filename = args[loop + 1];
                    loop++;
                    break;
                case "-n":
                    linenumber = StringSpecificationOutput.specLineNumber(args[loop + 1]);
                    loop++;
                    break;
                case "--set":
                    BaseEnvironment.setEnvironment(args[loop + 1], args[loop + 2]);
                    loop += 2;
                    break;
                case "-o":
                    BaseEnvironment.setEnvironment("baseFileDir", args[loop + 1]);
                    loop++;
                    break;
                case "-t":
                    BaseEnvironment.setEnvironment("TOTAL_THREADS", args[loop + 1]);
                    loop++;
                    break;
                case "-i":
                    BaseEnvironment.setEnvironment("toDB", args[loop + 1]);
                    loop++;
                    break;
                case "-h":
                    help.printHelpMessage();
                    System.exit(0);
                case "-O":
                    BaseEnvironment.setEnvironment("Optimal", "true");
                    break;
                case "-L":
                    BaseEnvironment.setEnvironment("longerInsert", "true");
                    break;
                case "-N":
                    BaseEnvironment.setEnvironment("canbeNegative", "true");
                    break;
                case "-v":
//                case "-version":
                    help.printVersion();
                    System.exit(0);
            }
        }
        
        try {
            if (filename == null) {
                System.out.println("输入create SQL");
                FileString = scanf.nextLine();
            } else
                FileString = FileLoader.loadFile(new File(filename));
        } catch (IOException e) {
            System.err.println("指定文件不存在");
            System.exit(-1);
            return;
        }

        Collection<TableStructure> tablesMetaData = antlrProcess(FileString);

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
        for (Collection<TableMaker> maker : tableMakers) {
            //根据每张表的maker数量建立线程数量，并放到线程池中
        }
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

    private static void help() {
        help.printHelpMessage();
    }
}
