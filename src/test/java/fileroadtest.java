import Utils.datastruc.CreateTableStruc;
import Utils.insert.CreateInsertSQLFile;
import Utils.datastruc.Fileloader;
import dataStruture.TableStructure;
import org.junit.Test;

import java.io.File;

public class fileroadtest {
    @Test
    public void main(String[] args) throws Exception {
        String FileString=Fileloader.loadingFile(new File("E:\\Work\\tpch.sql"));
        String[] createSQLs=FileString.split(";");

        CreateInsertSQLFile createInsertSQLFile=new CreateInsertSQLFile();
        for(String SQL:createSQLs) {
            TableStructure ts = CreateTableStruc.makeStructure(SQL + ';');
            createInsertSQLFile.createInsertSQLFile(ts, 20.0);
        }
    }


}