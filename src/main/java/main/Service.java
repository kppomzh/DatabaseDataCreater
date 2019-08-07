package main;

import Utils.FileLoader;
import Utils.TableStructure.CreateTableStructure;
import Utils.env_properties;
import Utils.insert.CreateInsertSQLProcess;
import dataStructure.TableStructure;

import java.io.File;
import java.util.Scanner;

public class Service {
    private static Scanner scanf = new Scanner(System.in);

    public static void main(String[] args){
        String filename = null, FileString;
        String[] createSQLs = null;
        Double linenumber = null;
        for (int loop = 0; loop < args.length; loop++) {
            switch (args[loop]) {
                case "-f":
                    filename = args[loop + 1];
                    loop++;
                    break;
                case "-n":
                    linenumber = Double.valueOf(args[loop + 1]);
                    loop++;
                    break;
                case "--set":
                    env_properties.setEnvironment(args[loop + 1].split(",")[0], args[loop + 1].split(",")[1]);
                    loop++;
                    break;
                case "-o":
                    env_properties.setEnvironment("baseFileDir", args[loop + 1]);
                    loop++;
                    break;
                case "-t":
                    env_properties.setEnvironment("TOTAL_THREADS", args[loop + 1]);
                    loop++;
                    break;
                case "-i":
                    env_properties.setEnvironment("toDB", args[loop + 1]);
                    loop++;
                    break;
                case "-h":
                    help.printHelpMessage();
                    System.exit(0);
                case "-O":
                    env_properties.setEnvironment("Optimal", "true");
                    break;
                case "-a":
                    env_properties.setEnvironment("asynchronous", "true");
                    break;
                case "-L":
                    env_properties.setEnvironment("longerInsert", "true");
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
            if (linenumber == null) {
                System.out.println("输入create number");
                linenumber = scanf.nextDouble();
            }
            createSQLs = FileString.replace("\r","").split(";");

            for (int i = 0; i < createSQLs.length; i++) {
                TableStructure ts = CreateTableStructure.makeStructure(createSQLs[i] + ';');
                CreateInsertSQLProcess createInsertSQLProcess = new CreateInsertSQLProcess(ts, linenumber);
                createInsertSQLProcess.createInsertSQLFile();//args -n linenumber
            }
        }catch(Throwable t){
            System.out.println(t.getMessage());
        }
    }
}
