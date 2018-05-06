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
        textFileWriter fileWriter = null;

        int outnum = linenumber.intValue() % TOTAL_THREADS;

        try {
            fileWriter = new textFileWriter(env_properties.getEnvironment("baseFileDir") + ts.getTbname() + ".sql");
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 1; i < TOTAL_THREADS; i++)
        {
            tasks.add(service.submit(new InsertSQLCreater(ts.getTbname(),
                    (TableStructure)ts.clone(),
                    (linenumber - outnum) / TOTAL_THREADS,
                    fileWriter)));
        }
        tasks.add(service.submit(new InsertSQLCreater(ts.getTbname(),
                (TableStructure)ts.clone(),
                (linenumber - outnum) / TOTAL_THREADS+outnum,
                fileWriter)));
        service.shutdown();
        Thread.sleep((long) (linenumber/40000));
        service.awaitTermination(1,TimeUnit.HOURS);

//            new Thread(new InsertSQLCreater(ts.getTbname(),
//                    (TableStructure) ts.clone(),
//                    (linenumber.intValue() - outnum) / TOTAL_THREADS,
//                    fileWriter)
//                    .setstart(mStartSignal, mDoneSignal, i)).start();
//        new Thread(new InsertSQLCreater(ts.getTbname(),
//                (TableStructure) ts.clone(),
//                (linenumber.intValue() - outnum) / TOTAL_THREADS + outnum,
//                fileWriter)
//                .setstart(mStartSignal, mDoneSignal, TOTAL_THREADS)).start();

//        mStartSignal.countDown();// 计数减一为0，工作线程真正启动具体操作
//        try {
//            mDoneSignal.await();// 等待所有工作线程结束
//        } catch (InterruptedException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            result = false;
//        } finally {
            fileWriter.closeWriter();
            return result;
//        }

    }
}
