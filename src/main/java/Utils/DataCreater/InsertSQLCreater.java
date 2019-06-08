package Utils.DataCreater;

import Utils.DataCreater.FiledCreater.baseCreater;
import Utils.DataWriter.tF;
import Utils.Factorys.FiledCreaterFactory;
import Utils.env_properties;
import dataStructure.TableStructure;

/**
 * 产生独立线程和数据格式判断
 */
public class InsertSQLCreater implements Runnable {

    private int makenumber;
    private tF writer;

    private baseCreater bc;
    private int partCreatemax=1;

    public InsertSQLCreater(String tablename, TableStructure tableStructure, int makenumber, tF writer) {
        this.makenumber = makenumber;
        this.writer = writer;
        bc= FiledCreaterFactory.getFiledCreater(tableStructure);
        if(env_properties.getEnvironment("longerInsert").equals("true")){
            partCreatemax=Integer.valueOf(env_properties.getEnvironment("longerInsertNumber"));
        }
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
