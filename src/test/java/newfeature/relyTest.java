package newfeature;

import CreateSQLParser.TableStructure.CreateTableStructure;
import Utils.FileLoader;
import Utils.env_properties;
import Utils.insert.CreateInsertSQLProcess;
import Utils.relyCalculation;
import dataStructure.TableStructure;
import main.help;
import org.junit.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class relyTest {
    @Test
    public void relyTest(){
        String FileString;
        String[] createSQLs;
        Double linenumber = 10d;
        env_properties.setEnvironment("toDB", "sql");
        env_properties.setEnvironment("baseFileDir", "./");
        env_properties.setEnvironment("TOTAL_THREADS", "1");
        env_properties.setEnvironment("longerInsert", "true");
        env_properties.setEnvironment("canbeNegative", "true");
        env_properties.setEnvironment("WriterEngine","screenout");

        try {
            FileString = FileLoader.loadFile(new File("rely.sql"));
            createSQLs = FileString.replace("\r","").split(";");

            Map<String, TableStructure> structureMap=new HashMap<>();
            for (int i = 0; i < createSQLs.length; i++) {
                if(createSQLs[i].length()>13) {
                    TableStructure ts = CreateTableStructure.makeStructure(createSQLs[i] + ';');
                    structureMap.put(ts.getTbname(), ts);
                }
            }
            relyCalculation rely=new relyCalculation(structureMap);
            structureMap=rely.makeNodeMap();

            for(TableStructure ts:structureMap.values()){
                ts.getTbname();
                CreateInsertSQLProcess createInsertSQLProcess = new CreateInsertSQLProcess(ts, linenumber);
                createInsertSQLProcess.createInsertSQLFile();//args -n linenumber
            }
        }catch(Throwable t){
            System.out.println(t.getMessage());
        }
    }
}
