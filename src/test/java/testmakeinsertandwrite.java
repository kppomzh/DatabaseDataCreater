import Utils.insert.InsertSQLCreater;
import Utils.insert.textFileWriter;
import dataStruture.TableStructure;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class testmakeinsertandwrite {
    private static final int TOTAL_THREADS = 8;
    private static final CountDownLatch mStartSignal = new CountDownLatch(1);
    private static final CountDownLatch mDoneSignal = new CountDownLatch(TOTAL_THREADS);

    public static void main(String ar[]) throws IOException, CloneNotSupportedException {
        long time=System.currentTimeMillis();

        TableStructure ts=new TableStructure();
        ts.addlist("string",false,false,5);
        ts.addlist("number",false,false,2,3);
        ts.addlist("string",false,false,4);
        ts.addlist("date",false,false);

        textFileWriter fileWriter=new textFileWriter("E:\\sql1.sql");
        fileWriter.WriteLine("set dialect='oracle';");
        for (int i = 0; i < TOTAL_THREADS; i++)
//            new Thread(new InsertSQLCreater("zhzm1",(TableStructure)ts.clone(),2500000,fileWriter)
//                    .setstart(mStartSignal, mDoneSignal, i)).start();

        mStartSignal.countDown();// 计数减一为0，工作线程真正启动具体操作
        try
        {
            mDoneSignal.await();// 等待所有工作线程结束
        }
        catch (InterruptedException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally {
            fileWriter.closeWriter();
        }

        System.out.print((System.currentTimeMillis()-time)/1000.0);
    }
}
