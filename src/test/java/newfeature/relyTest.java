package newfeature;

import CreateSQLParser.TableStructure.CreateTableStructure;
import Utils.FileLoader;
import Utils.baseEnvironment;
import Utils.insert.CreateInsertSQLProcess;
import Utils.relyCalculation;
import dataStructure.TableStructure;
import org.junit.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class relyTest {
    @Test
    public void relyTest(){
        String FileString;
        String[] createSQLs;
        Double linenumber[] = {5d,10d,50d};
        baseEnvironment.setEnvironment("toDB", "sql");
        baseEnvironment.setEnvironment("baseFileDir", "./");
        baseEnvironment.setEnvironment("TOTAL_THREADS", "1");
        baseEnvironment.setEnvironment("longerInsert", "false");
        baseEnvironment.setEnvironment("canbeNegative", "true");
        baseEnvironment.setEnvironment("WriterEngine","screenout");

        try {
            FileString = FileLoader.loadFile(new File("rely.sql"));
            createSQLs = FileString.replace("\r","").split(";");

            Map<String, TableStructure> structureMap=new HashMap<>();
            int SQLnum=0;
            for (int i = 0; i < createSQLs.length; i++) {
                if (createSQLs[i].length() > 13) {
                    TableStructure ts = CreateTableStructure.makeStructure(createSQLs[i] + ';');
                    structureMap.put(ts.getTbname(), ts);
                    if(linenumber.length>SQLnum){
                        ts.setSize(linenumber[SQLnum]);
                    }
                    else{
                        System.out.println("表 "+ts.getTbname()+" 没有指定生成行数，请手动输入：");
                        ts.setSize(1);
                    }
                    SQLnum++;
                }
            }
            relyCalculation rely=new relyCalculation(structureMap);
            structureMap=rely.makeNodeMap();

            for(TableStructure ts:structureMap.values()){
                ts.getTbname();
                CreateInsertSQLProcess createInsertSQLProcess = new CreateInsertSQLProcess(ts);
                createInsertSQLProcess.createInsertSQLFile();//args -n linenumber
            }
        }catch(Throwable t){
            System.out.println(t.getMessage());
        }
    }
}
