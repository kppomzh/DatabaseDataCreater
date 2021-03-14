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
        String filename = null, FileString;
        String[] createSQLs;
        Double linenumber = 10d;
        env_properties.setEnvironment("toDB", "sql");
        env_properties.setEnvironment("baseFileDir", "./");
        env_properties.setEnvironment("TOTAL_THREADS", "2");
        env_properties.setEnvironment("longerInsert", "true");
        env_properties.setEnvironment("canbeNegative", "true");

        try {
            FileString = FileLoader.loadFile(new File("rely.sql"));
            createSQLs = FileString.replace("\r","").split(";");

            Map<String, TableStructure> structureMap=new HashMap<>();
            for (int i = 0; i < createSQLs.length; i++) {
                TableStructure ts = CreateTableStructure.makeStructure(createSQLs[i] + ';');
                structureMap.put(ts.getTbname(),ts);
            }
            relyCalculation rely=new relyCalculation(structureMap);
            structureMap=rely.makeNodeMap();

            for(TableStructure ts:structureMap.values()){
                ts.toString();
            }
        }catch(Throwable t){
            System.out.println(t.getMessage());
        }
    }
}
