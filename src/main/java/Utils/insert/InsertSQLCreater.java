package Utils.insert;

import Utils.RandomBasicDataCreater;
import Utils.env_properties;
import dataStruture.ListStructure;
import dataStruture.TableStructure;

public class InsertSQLCreater implements Runnable{

    private String tablename;
    private TableStructure tableStructure;
    private double makenumber;
    private tF writer;
    public InsertSQLCreater(String tablename, TableStructure tableStructure,double makenumber,tF writer){
        this.tablename=tablename;
        this.tableStructure=tableStructure;
        this.makenumber=makenumber;
        this.writer=writer;
    }

    @Override
    public void run() {
//        try {
//            mStartSignal.await();
            // 所有的工作线程都在等待同一个启动的命令
            for(double loop=0;loop<makenumber;loop++)
                makeainsert();
//            mDoneSignal.countDown();// 完成以后计数减一
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    private void makeainsert()
    {
        StringBuffer sb=new StringBuffer();
        if(env_properties.getEnvironment("toDB").equals("file")){
            sb.append("insert into ");
            sb.append(tablename);
            sb.append(" values(");
        }
        while (tableStructure.hasNext())
        {
            ListStructure ls=tableStructure.getNextStruc();
            switch (ls.getListType())
            {
                case "number":
                    sb.append(RandomBasicDataCreater.getNumber(ls.getRange()[0],ls.getRange()[1],true));
                    break;
                case "string":
                    sb.append(RandomBasicDataCreater.getStr(ls.getRange()[0]));
                    break;
                case "date":
                    sb.append(RandomBasicDataCreater.getDate());
                    break;

            }
            sb.append(',');
        }
        sb.deleteCharAt(sb.length()-1);
        if(env_properties.getEnvironment("toDB").equals("file")) {
            sb.append(");");
        }
        writer.WriteLine(sb.toString());
    }

//    public Runnable setstart(CountDownLatch mStartSignal,CountDownLatch mDoneSignal,int i)
//    {
//        this.mStartSignal=mStartSignal;
//        this.mDoneSignal=mDoneSignal;
//        this.mThreadIndex=i;
//        return this;
//    }
}
