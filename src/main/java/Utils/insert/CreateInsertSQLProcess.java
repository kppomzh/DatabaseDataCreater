package Utils.insert;

import Utils.DataWriter.*;
import Utils.env_properties;
import dataStructure.TableStructure;

import javax.security.auth.callback.Callback;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CreateInsertSQLProcess implements Callback {
    private int basicThreads = Integer.valueOf(env_properties.getEnvironment("nCPU"));
    private int TOTAL_THREADS = Integer.valueOf(env_properties.getEnvironment("TOTAL_THREADS"));
    private ExecutorService service = Executors.newFixedThreadPool(basicThreads);//根据CPU核心最大值确定线程数量，一般是核心数减一
    private TableStructure ts;
    private int[] linenumber;
    private ConcurrentLinkedQueue<String> tempPool;

    /**
     * @param ts 每个表的解析信息
     * @param linenumber 总的生成行数
     */
    public CreateInsertSQLProcess(TableStructure ts, double linenumber) {
        this.ts = ts;
        this.linenumber = new int[TOTAL_THREADS];
        for (int loop = 1; loop < TOTAL_THREADS; loop++)
            this.linenumber[loop] = (int) linenumber / TOTAL_THREADS;
        this.linenumber[0] = (int) linenumber / TOTAL_THREADS + (int) linenumber % TOTAL_THREADS;
        if(ts.isPrimary()){
            ts.setPrimaryInterval(BigInteger.valueOf(TOTAL_THREADS>1?this.linenumber[1]:this.linenumber[0]));
        }
        tempPool=new ConcurrentLinkedQueue<>();
    }

    public void createInsertSQLFile() throws Exception {
        int close_loop = 1;
        List<tF> writerlist = new ArrayList<>();

        if (TOTAL_THREADS>1) {
            close_loop = TOTAL_THREADS;
            for (int loop = 0; loop < TOTAL_THREADS; loop++) {
                writerlist.add(getWriter(ts.getTbname() + loop));
            }
        } else {
            writerlist.add(getWriter(ts.getTbname()));
        }
        makePool();

        service.shutdown();
        service.awaitTermination(7, TimeUnit.DAYS);

        for (int loop = 0; loop < close_loop; loop++) {
            writerlist.get(loop).close();
        }
    }

    private void makePool() throws CloneNotSupportedException {

    }

    private tF getWriter(String tablename) throws IOException {
        String filename = env_properties.getEnvironment("baseFileDir") + tablename + "." + env_properties.getEnvironment("toDB");
        if (env_properties.getEnvironment("toDB").equals("jdbc")) {
            return new textFileJDBC();
        } else switch(env_properties.getEnvironment("WriterEngine")){
            case "apache":
                return new ApacheFileWriter(filename);
            case "screenout":
                return new SystemoutWriter();
            default :
                if(env_properties.getEnvironment("compress").equals("true"))
                    return new textCompressWriter(filename);
                else
                    return new textFileWriter(filename);
        }
    }

    public void putPool(String str){
        tempPool.add(str);
    }
}
