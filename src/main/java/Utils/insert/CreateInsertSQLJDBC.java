package Utils.insert;

import Utils.env_properties;
import dataStruture.TableStructure;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class CreateInsertSQLJDBC {
    private static final int TOTAL_THREADS = Integer.valueOf(env_properties.getEnvironment("TOTAL_THREADS"));

    public boolean CreateInsertSQLJDBC(TableStructure ts, Double linenumber) throws Exception {
        ExecutorService service = Executors.newFixedThreadPool(TOTAL_THREADS);
        List<Future<?>> tasks = new ArrayList<>();//Future接口提供方法来检测任务是否被执行完，等待任务执行完获得结果，也可以设置任务执行的超时时间。
        boolean result = true;

        double outnum = linenumber % TOTAL_THREADS;
        double threadlinenum=(linenumber - outnum) / TOTAL_THREADS;

        for (int i = 1; i < TOTAL_THREADS; i++)
        {
            tasks.add(service.submit(new InsertSQLCreater(ts.getTbname(),
                    (TableStructure)ts.clone(),
                    threadlinenum,
                    new textFileJDBC())));
        }
        tasks.add(service.submit(new InsertSQLCreater(ts.getTbname(),
                (TableStructure)ts.clone(),
                threadlinenum+outnum,
                new textFileJDBC())));
        service.shutdown();
        Thread.sleep((long) (linenumber/40000));
        service.awaitTermination(1,TimeUnit.HOURS);

//        new InsertSQLCreater(ts.getTbname(),
//                (TableStructure)ts.clone(),
//                linenumber.intValue(),
//                new textFileJDBC()).singalrun();
        return result;
    }
}
