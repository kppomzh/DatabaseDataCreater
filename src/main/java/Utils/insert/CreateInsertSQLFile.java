package Utils.insert;

import Utils.env_properties;
import dataStruture.TableStructure;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CreateInsertSQLFile {
    private static final int TOTAL_THREADS = Integer.valueOf(env_properties.getEnvironment("TOTAL_THREADS"));

    public /*static*/ boolean createInsertSQLFile(TableStructure ts, Double linenumber) throws Exception {
        ExecutorService service = Executors.newFixedThreadPool(TOTAL_THREADS);
        List<Future<?>> tasks = new ArrayList<>();//Future接口提供方法来检测任务是否被执行完，等待任务执行完获得结果，也可以设置任务执行的超时时间。
        boolean result = true;
        textFileWriter fileWriter = null,writers[]=new textFileWriter[TOTAL_THREADS];

        int outnum = linenumber.intValue() % TOTAL_THREADS;

        if(env_properties.getEnvironment("asynchronous").equals("true"))
            for(int loop=0;loop<TOTAL_THREADS;loop++)
            {
                writers[loop]=new textFileWriter(env_properties.getEnvironment("baseFileDir") + ts.getTbname() +loop+ ".sql");
            }
        else {
            fileWriter = new textFileWriter(env_properties.getEnvironment("baseFileDir") + ts.getTbname() + ".sql");
            for(int loop=0;loop<TOTAL_THREADS;loop++)
                writers[loop]=fileWriter;
        }

        for (int i = 1; i < TOTAL_THREADS; i++)
        {
            tasks.add(service.submit(new InsertSQLCreater(ts.getTbname(),
                    (TableStructure)ts.clone(),
                    (linenumber - outnum) / TOTAL_THREADS,
                    writers[i])));
        }
        tasks.add(service.submit(new InsertSQLCreater(ts.getTbname(),
                (TableStructure)ts.clone(),
                (linenumber - outnum) / TOTAL_THREADS+outnum,
                writers[0])));
        service.shutdown();
        Thread.sleep((long) (linenumber/40000));
        service.awaitTermination(1,TimeUnit.HOURS);

        if(env_properties.getEnvironment("asynchronous").equals("true"))
            for(int loop=0;loop<TOTAL_THREADS;loop++)
            {
                writers[loop].closeWriter();
            }
        else
            fileWriter.closeWriter();
        return result;
    }
}
