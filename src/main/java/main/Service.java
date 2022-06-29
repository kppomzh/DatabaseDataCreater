package main;

import Utils.FileLoader;
import CreateSQLParser.TableStructure.CreateTableStructure;
import Utils.StringSpecificationOutput;
import Utils.baseEnvironment;
import Utils.insert.CreateInsertSQLProcess;
import Utils.relyCalculation;
import dataStructure.TableStructure;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Service {
    private static Scanner scanf = new Scanner(System.in);

    public static void main(String[] args) {
        String filename = null, FileString;
        String[] createSQLs;
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
                    baseEnvironment.setEnvironment(args[loop + 1], args[loop + 2]);
                    loop += 2;
                    break;
                case "-o":
                    baseEnvironment.setEnvironment("baseFileDir", args[loop + 1]);
                    loop++;
                    break;
                case "-t":
                    baseEnvironment.setEnvironment("TOTAL_THREADS", args[loop + 1]);
                    loop++;
                    break;
                case "-i":
                    baseEnvironment.setEnvironment("toDB", args[loop + 1]);
                    loop++;
                    break;
                case "-h":
                    help.printHelpMessage();
                    System.exit(0);
                case "-O":
                    baseEnvironment.setEnvironment("Optimal", "true");
                    break;
                case "-L":
                    baseEnvironment.setEnvironment("longerInsert", "true");
                    break;
                case "-N":
                    baseEnvironment.setEnvironment("canbeNegative", "true");
                    break;
                case "-v":
//                case "-version":
                    help.printVersion();
                    System.exit(0);
            }
        }

        try {
            if (filename == null) {
                System.out.println("请通过命令行模式使用本程序");
                return ;
            } else
                FileString = FileLoader.loadFile(new File(filename));
            createSQLs = FileString.replace("\r", "").split(";");

            Map<String, TableStructure> structureMap = new HashMap<>();
            int SQLnum=0;
            for (int i = 0; i < createSQLs.length; i++) {
                if (!(createSQLs[i].length() <= 17 || createSQLs[i].matches("^\\s+$"))) {
                    TableStructure ts = CreateTableStructure.makeStructure(createSQLs[i] + ';');
                    structureMap.put(ts.getTbname(), ts);
                    if(linenumber.length>SQLnum){
                        ts.setSize(linenumber[SQLnum]);
                    }
                    else{
                        System.out.println("表 "+ts.getTbname()+" 没有指定生成行数，请手动输入：");
                        ts.setSize(scanf.nextDouble());
                    }
                    SQLnum++;
                }
            }
            relyCalculation rely = new relyCalculation(structureMap);
            structureMap = rely.makeNodeMap();

            for (TableStructure ts : structureMap.values()) {
                CreateInsertSQLProcess createInsertSQLProcess = new CreateInsertSQLProcess(ts);
                createInsertSQLProcess.createInsertSQLFile();//args -n linenumber
            }
        } catch (Throwable t) {
            System.out.println(t.getMessage());
        }
    }
}