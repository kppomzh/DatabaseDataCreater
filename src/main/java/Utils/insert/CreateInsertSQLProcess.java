package Utils.insert;

import Utils.CircularLinkedList;
import Utils.DataCreater.InsertSQLCreater;
import Utils.DataWriter.ApacheFileWriter;
import Utils.DataWriter.tF;
import Utils.DataWriter.textFileJDBC;
import Utils.DataWriter.textFileWriter;
import Utils.env_properties;
import dataStructure.TableStructure;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CreateInsertSQLProcess {
    private static final int basicThreads = Integer.valueOf(env_properties.getEnvironment("nCPU"));
    private static final int TOTAL_THREADS = Integer.valueOf(env_properties.getEnvironment("TOTAL_THREADS"));
    private ExecutorService service = Executors.newFixedThreadPool(basicThreads);//根据CPU核心最大值确定线程数量，一般是核心数减一
    private TableStructure ts;
    private int[] linenumber;

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
    }

    public void createInsertSQLFile() throws Exception {
        int close_loop = 1;
        CircularLinkedList<tF> writerlist = new CircularLinkedList<>();

        if (env_properties.getEnvironment("asynchronous").equals("true")) {
            close_loop = TOTAL_THREADS;
            for (int loop = 0; loop < TOTAL_THREADS; loop++) {
                writerlist.add(getWriter(ts.getTbname() + loop, "utf-8"));
            }
        } else {
            writerlist.add(getWriter(ts.getTbname(), "utf-8"));
        }
        makePool(writerlist);

        service.shutdown();
        service.awaitTermination(7, TimeUnit.DAYS);

        for (int loop = 0; loop < close_loop; loop++) {
            writerlist.getNext().closeWriter();
        }
    }

    private void makePool(CircularLinkedList<tF> writerlist) throws CloneNotSupportedException {
        for (int loop = 0; loop < TOTAL_THREADS; loop++)
            service.execute(new InsertSQLCreater(ts.getTbname(),
                    (TableStructure) ts.clone(),
                    linenumber[loop],
                    writerlist.getNext()));
    }

    private tF getWriter(String tablename, String charset) throws IOException {
        String filename = env_properties.getEnvironment("baseFileDir") + tablename + "." + env_properties.getEnvironment("toDB");
        if (env_properties.getEnvironment("toDB").equals("jdbc")) {
            return new textFileJDBC();
        } else if (env_properties.getEnvironment("WriterEngine").equals("default")) {
            return new textFileWriter(filename);
        } else {
            return new ApacheFileWriter(filename, charset);
        }
    }
}
