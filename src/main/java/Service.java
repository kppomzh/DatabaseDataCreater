import Utils.insert.CreateInsertSQLJDBC;
import Utils.datastruc.CreateTableStruc;
import Utils.datastruc.Fileloader;
import Utils.env_properties;
import Utils.insert.CreateInsertSQLFile;
import Utils.insert.textFileJDBC;
import dataStruture.TableStructure;

import java.io.File;
import java.util.Scanner;

public class Service {
    private static Scanner scanf=new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        String filename=null,FileString;
        String[] createSQLs=null;
        Double linenumber = null;
        for(int loop=0;loop<args.length-1;loop++)
        {
            switch (args[loop]) {
                case "-f":
                    System.out.print(":");
                    filename = args[loop + 1];
                    break;
                case "-n":
                    linenumber = Double.valueOf(args[loop + 1]);
                    break;
                case "-s":
                    env_properties.setEnvironment(args[loop + 1].split(",")[0], args[loop + 1].split(",")[1]);
                    break;
                case "-o":
                    env_properties.setEnvironment("baseFileDir", args[loop + 1]);
                    break;
                case "-t":
                    env_properties.setEnvironment("TOTAL_THREADS", args[loop + 1]);
                case "-h":
                    new help().printHelpMessage();
                    System.exit(0);
            }
        }
        if(filename==null) {
            System.out.println("输入create SQL");
            FileString = scanf.nextLine();
        }
        else
            FileString = Fileloader.loadingFile(new File(filename));//args -f filename
        if(linenumber==null) {
            System.out.println("输入create number");
            linenumber = scanf.nextDouble();
        }
        createSQLs=FileString.split(";");


        for(String SQL : createSQLs) {
            TableStructure ts = CreateTableStruc.makeStructure(SQL + ';');
            if (env_properties.getEnvironment("toDB").equals("jdbc"))
            {
                new textFileJDBC().WriteCreateinJDBC(SQL + ';');//先自动建表，即使已经有表失败也无所谓
                CreateInsertSQLJDBC sqljdbc=new CreateInsertSQLJDBC();
                sqljdbc.CreateInsertSQLJDBC(ts,linenumber);
            }
            else {
                CreateInsertSQLFile createInsertSQLFile = new CreateInsertSQLFile();
                createInsertSQLFile.createInsertSQLFile(ts, linenumber);//args -n linenumber
            }
        }
    }
}
