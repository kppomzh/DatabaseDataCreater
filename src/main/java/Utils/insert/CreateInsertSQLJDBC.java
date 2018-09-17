package Utils.insert;

import Utils.DataCreater.InsertSQLCreater;
import Utils.env_properties;
import dataStruture.TableStructure;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CreateInsertSQLJDBC {
    private static final int baseThreads=Integer.valueOf(env_properties.getEnvironment("nCPU"));
    private static final int TOTAL_THREADS = Integer.valueOf(env_properties.getEnvironment("TOTAL_THREADS"));

    public boolean CreateInsertSQLJDBC(TableStructure ts, Double linenumber) throws Exception {
        ExecutorService service = Executors.newFixedThreadPool(baseThreads);
        List<Future<?>> tasks = new ArrayList<>();//Future接口提供方法来检测任务是否被执行完，等待任务执行完获得结果，也可以设置任务执行的超时时间。
        tF writers[]=new textFileWriter[TOTAL_THREADS];
        boolean result = true;

        double outnum = linenumber % TOTAL_THREADS;
        double threadlinenum=(linenumber - outnum) / TOTAL_THREADS;

        for (int i = 1; i < TOTAL_THREADS; i++)
        {
            writers[i]=new textFileJDBC();
            tasks.add(service.submit(new InsertSQLCreater(ts.getTbname(),
                    (TableStructure)ts.clone(),
                    threadlinenum,
                    writers[i])));
        }
        writers[0]=new textFileJDBC();
        tasks.add(service.submit(new InsertSQLCreater(ts.getTbname(),
                (TableStructure)ts.clone(),
                threadlinenum+outnum,
                writers[0])));
        service.shutdown();
        Thread.sleep((long) (linenumber/40000));
        service.awaitTermination(1,TimeUnit.HOURS);

        for(int loop=0;loop<TOTAL_THREADS;loop++)
        {
            writers[loop].closeWriter();
        }
        return result;
    }
}
