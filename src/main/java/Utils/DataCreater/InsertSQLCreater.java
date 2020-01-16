package Utils.DataCreater;

import Utils.DataCreater.FiledCreater.baseCreater;
import Utils.DataWriter.tF;
import Utils.Factorys.FiledCreaterFactory;
import Utils.env_properties;
import dataStructure.TableStructure;

import java.io.ByteArrayInputStream;
import java.util.Objects;

/**
 * 产生独立线程和数据格式判断
 */
public class InsertSQLCreater implements Runnable {

    private int makenumber;
    private tF writer;

    private baseCreater bc;
    private int partCreatemax;

    public InsertSQLCreater(String tablename, TableStructure tableStructure, int makenumber, tF writer) {
        this.makenumber = makenumber;
        this.writer = writer;
        bc= FiledCreaterFactory.getFiledCreater(tableStructure);
        partCreatemax=Objects.equals(env_properties.getEnvironment("longerInsert"), "true")?
                Integer.valueOf(env_properties.getEnvironment("longerInsertNumber")):1;
    }

    @Override
    public void run() {
        while(makenumber>=partCreatemax){
            String toWrite = bc.makeinsert(partCreatemax);
            writer.WriteLine(toWrite);
            makenumber-=partCreatemax;
        }

        if(makenumber>0) {
            writer.WriteLine(bc.makeinsert(makenumber));
        }
    }
}
