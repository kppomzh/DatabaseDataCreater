package main.control;

import Utils.DataWriter.Writer;
import Utils.env_properties;
import Utils.insert.SQLCreaterRunner;
import dataStructure.TableStructure;

import javax.security.auth.callback.Callback;
import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class start implements Callback {
    private int basicThreads = Integer.valueOf(env_properties.getEnvironment("nCPU"));
    private int TOTAL_THREADS = Integer.valueOf(env_properties.getEnvironment("totalThreads"));
    private ExecutorService service = Executors.newFixedThreadPool(basicThreads);//根据CPU核心最大值确定线程数量，一般是核心数减一
    protected TableStructure ts;
    protected Writer writer;
    protected int[] linenumber;

    public void setTableStructure(TableStructure ts) {
        this.ts = ts;

        if(ts.isPrimary()){
            ts.setPrimaryInterval(BigInteger.valueOf(TOTAL_THREADS>1?this.linenumber[1]:this.linenumber[0]));
        }
    }

    protected void setLineNumber(Double setnumber){
        this.linenumber = new int[TOTAL_THREADS];
        for (int loop = 1; loop < TOTAL_THREADS; loop++) {
            this.linenumber[loop] = setnumber.intValue() / TOTAL_THREADS;
        }
        this.linenumber[0] = setnumber.intValue() / TOTAL_THREADS + setnumber.intValue() % TOTAL_THREADS;
    }

    public abstract void start() throws IOException;

    public abstract void createInsertPool() throws CloneNotSupportedException;

    protected void makePool() throws CloneNotSupportedException {
        for (int loop = 0; loop < TOTAL_THREADS; loop++)
            service.execute(new SQLCreaterRunner(
                    (TableStructure) ts.clone(),
                    linenumber[loop],
                    this));
    }

    public abstract void send(String str);

    protected abstract <T> Writer getWriter(T obj) throws IOException;
}
