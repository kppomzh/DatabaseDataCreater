package main.control.local;

import CreateSQLParser.TableStructure.CreateTableStructure;
import Utils.DataWriter.*;
import Utils.Factorys.getEnvRecordFactory;
import Utils.FileLoader;
import Utils.BaseProperties;
import Utils.insert.SQLCreaterRunner;
import dataStructure.RuntimeEnvironment;
import dataStructure.TableStructure;
import main.control.start;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LocalStart extends start {
    private int basicThreads = Integer.valueOf(BaseProperties.getEnvironment("nCPU"));
    private int TOTAL_THREADS = Integer.valueOf(BaseProperties.getEnvironment("totalThreads"));
    private String filename;
    private static Scanner scanf = new Scanner(System.in);
    private RuntimeEnvironment thisEnv;
    private TransferQueue<String> writeCache;

    protected ExecutorService service;//根据CPU核心最大值确定线程数量，一般是核心数减一
    protected TableStructure ts;
    protected BaseWriter writer;
    protected int[] linenumber;

    public LocalStart(String linenumber, String SQLFilename) {
        filename = SQLFilename;
        checkMsg(linenumber);
        //根据CPU核心最大值确定线程数量，一般是核心数减一
        service = Executors.newFixedThreadPool(basicThreads+1);
        writeCache=new LinkedTransferQueue<>();
    }

    @Override
    public void startService() {
        List<Exception> exList = new LinkedList<>();
        String[] createSQLs = thisEnv.getSQLString().replace("\r", "").split(";");
        for (int i = 0; i < createSQLs.length; i++) {
            try {
                ts = CreateTableStructure.makeStructure(createSQLs[i] + ';', thisEnv);
                setLineNumber(thisEnv.getCreateNum());
                setTableStructure();
                createInsertPool();
                writer = getWriter(ts.getTbname());

                service.shutdown();
                service.awaitTermination(7, TimeUnit.DAYS);
            } catch (Exception e) {
                Exception msg = new Exception("SQL: '" + createSQLs[i] + "'\n has some error.");
                msg.setStackTrace(e.getStackTrace());
                exList.add(msg);
            }
        }
    }

    protected void createInsertPool() throws CloneNotSupportedException {
        service.execute(writer);
        for (int loop = 0; loop < TOTAL_THREADS; loop++)
            service.execute(new SQLCreaterRunner(
                    (TableStructure) ts.clone(),
                    linenumber[loop],
                    writeCache,
                    thisEnv));
    }

    private void checkMsg(String linenumber) {
        HashMap<String, String> template = new HashMap<>();

        if (filename == null) {
            System.out.println("输入create SQL");
            template.put("SQLString", scanf.nextLine());
        } else {
            try {
                template.put("SQLString", FileLoader.loadFile(new File(filename)));
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }
        if (linenumber == null) {
            System.out.println("输入create number");
            template.put("createNum", scanf.nextLine());
        } else {
            template.put("createNum", linenumber);
        }

        thisEnv = getEnvRecordFactory.getRuntimeEnv(template);
    }

    protected <T> BaseWriter getWriter(T obj) throws IOException {
        String filename = thisEnv.getBaseFileDir() + obj + "." + thisEnv.getToDB();
        if (thisEnv.getToDB().equals("jdbc")) {
            return new textFileJDBC(thisEnv,writeCache);
        } else switch (thisEnv.getWriterEngine()) {
            case "apache":
                return new ApacheFileWriter(filename, thisEnv,writeCache);
            case "screenout":
                return new SystemoutWriter(thisEnv,writeCache);
            default:
                return new textFileWriter(filename, thisEnv,writeCache);
        }
    }

    protected void setTableStructure() {
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
}
