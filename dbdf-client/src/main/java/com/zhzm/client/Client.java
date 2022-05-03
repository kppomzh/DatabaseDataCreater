package com.zhzm.client;

import com.zhzm.antlr.createLexer;
import com.zhzm.antlr.createParser;
import com.zhzm.datastructure.table.TableStructure;
import com.zhzm.parser.CreateListenerImpl;
import com.zhzm.utils.FileLoader;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.smartboot.socket.transport.AioQuickClient;
import org.smartboot.socket.transport.AioSession;
import com.zhzm.client.utils.ClientProcessor;
import com.zhzm.utils.aio.StringProtocol;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Scanner;

public class Client {
    private static final Scanner scanf = new Scanner(System.in);

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        String host = null,port = "8088",type="sql",filename=null,outputDir="./";
        for (int loop = 0; loop < args.length; loop++) {
            switch (args[loop]) {
                case "-H":
                    loop++;
                    host = args[loop];
                    break;
                case "-p":
                    loop++;
                    port= args[loop];
                    break;
                case "-t":
                    loop++;
                    type= args[loop];
                    break;
                case "-f":
                    loop++;
                    filename=args[loop];
                    break;
                case "-o":
                    loop++;
                    outputDir=args[loop];
                    break;

                case "-h":
                    help.printHelpMessage();
                    System.exit(0);
                case "-v":
//                case "-version":
                    help.printVersion();
                    System.exit(0);
            }
        }

        assert host!=null;
        ClientProcessor processor=new ClientProcessor(type,outputDir);
        StringProtocol protocol=new StringProtocol();
        AioQuickClient client = new AioQuickClient(host, Integer.parseInt(port), protocol, processor);
        AioSession session = client.start();

        String FileString;
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

        session.writeBuffer().writeAndFlush(FileString.getBytes());
    }

    private static Collection<TableStructure> antlrProcess(String SQL){
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
