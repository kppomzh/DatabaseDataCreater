package Utils.insert;

import DataCreater.FiledCreater.baseFiledCreater;
import Utils.Factorys.FiledCreaterFactory;
import Utils.BaseProperties;
import dataStructure.RuntimeEnvironment;
import dataStructure.TableStructure;

import java.util.Objects;
import java.util.concurrent.TransferQueue;

/**
 * 产生独立线程和数据格式判断
 */
public class SQLCreaterRunner implements Runnable {

    private int makenumber;

    private baseFiledCreater bc;
    private int partCreatemax;
    private TransferQueue<String> writeCache;

    public SQLCreaterRunner(TableStructure tableStructure, int makenumber, TransferQueue<String> cache, RuntimeEnvironment env) {
        this.makenumber = makenumber;
        this.writeCache = cache;
        bc= FiledCreaterFactory.getFiledCreater(tableStructure,env);
        partCreatemax=Objects.equals(BaseProperties.getEnvironment("longerInsert"), "true")?
                Integer.valueOf(BaseProperties.getEnvironment("longerInsertNumber")):1;
    }

    @Override
    public void run() {
        while(makenumber>=partCreatemax){
            String toWrite = bc.makeinsert(partCreatemax);
            writeCache.add(toWrite);
            makenumber-=partCreatemax;
        }

        if(makenumber>0) {
            writeCache.add(bc.makeinsert(makenumber));
        }
    }
}
