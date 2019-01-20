package Utils.DataCreater;

import Utils.DataCreater.FiledCreater.*;
import Utils.Factorys.FiledCreaterFactory;
import Utils.env_properties;
import Utils.DataWriter.tF;
import dataStructure.TableStructure;

/**
 * 产生独立线程和数据格式判断
 */
public class InsertSQLCreater implements Runnable {

    private double makenumber;
    private tF writer;

    private baseCreater bc;

    public InsertSQLCreater(String tablename, TableStructure tableStructure, double makenumber, tF writer) {
        this.makenumber = makenumber;
        this.writer = writer;
        bc= FiledCreaterFactory.getFiledCreater(tableStructure);
    }

    @Override
    public void run() {
        for (double loop = 0; loop < makenumber; loop++) {
            try {
                String toWrite = bc.makeinsert();
                writer.WriteLine(toWrite);
            } catch (Exception e) {
                if (e.getMessage().equals("ta")) {
                    loop--;
                    continue;
                } else
                    throw new RuntimeException(e.getMessage());
            }
        }
    }
}
