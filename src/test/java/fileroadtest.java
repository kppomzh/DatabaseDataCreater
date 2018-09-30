import Utils.datastruc.CreateTableStruc;
import Utils.insert.CreateInsertSQLProcess;
import Utils.datastruc.Fileloader;
import dataStruture.TableStructure;

import java.io.File;

public class fileroadtest {
//    @Test
    public static void main(String[] args) throws Exception {
        String FileString=Fileloader.loadingFile(new File("E:\\Work\\tpch.sql"));
        String[] createSQLs=FileString.split(";");

        CreateInsertSQLProcess createInsertSQLProcess;
        for(String SQL:createSQLs) {
            TableStructure ts = CreateTableStruc.makeStructure(SQL + ';');
            createInsertSQLProcess =new CreateInsertSQLProcess(ts, 20.0);
            createInsertSQLProcess.createInsertSQLFile();
        }
        System.out.println(Runtime.getRuntime().availableProcessors());
    }


}