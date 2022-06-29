package Utils.insert;

import Utils.DataWriter.*;
import Utils.baseEnvironment;
import dataStructure.TableStructure;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CreateInsertSQLProcess {
    private int basicThreads = Integer.valueOf(baseEnvironment.getEnvironment("basicThread"));
    private int TOTAL_THREADS = Integer.valueOf(baseEnvironment.getEnvironment("TOTAL_THREADS"));
    private ExecutorService service = Executors.newFixedThreadPool(basicThreads);//根据CPU核心最大值确定线程数量，一般是核心数减一
    private TableStructure ts;
    private int[] linenumber;

    /**
     * @param ts 每个表的解析信息
     */
    public CreateInsertSQLProcess(TableStructure ts) {
        this.ts = ts;
        this.linenumber = new int[TOTAL_THREADS];
        for (int loop = 1; loop < TOTAL_THREADS; loop++)
            this.linenumber[loop] = (int) ts.getSize() / TOTAL_THREADS;
        this.linenumber[0] = (int) ts.getSize() / TOTAL_THREADS + (int) ts.getSize() % TOTAL_THREADS;
        if(ts.isPrimary()){
            ts.setPrimaryInterval(BigInteger.valueOf(TOTAL_THREADS>1?this.linenumber[1]:this.linenumber[0]));
        }
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
        makePool(writerlist);

        service.shutdown();
        service.awaitTermination(7, TimeUnit.DAYS);

        for (int loop = 0; loop < close_loop; loop++) {
            writerlist.get(loop).close();
        }
    }

    private void makePool(List<tF> writerlist) throws CloneNotSupportedException {
        for (int loop = 0; loop < TOTAL_THREADS; loop++)
            service.execute(new SQLCreaterRunner(
                    (TableStructure) ts.clone(),
                    linenumber[loop],
                    writerlist.get(loop)));
    }

    private tF getWriter(String tablename) throws IOException {
        String filename = baseEnvironment.getEnvironment("baseFileDir") + tablename + "." + baseEnvironment.getEnvironment("toDB");
        if (baseEnvironment.getEnvironment("toDB").equals("jdbc")) {
            return new textFileJDBC();
        } else switch(baseEnvironment.getEnvironment("WriterEngine")){
            case "apache":
                return new ApacheFileWriter(filename);
            case "screenout":
                return new SystemoutWriter();
            default :
//                if(baseEnvironment.getEnvironment("compress").equals("true"))
//                    return new textCompressWriter(filename);
//                else
                    return new textFileWriter(filename);
        }
    }
}
