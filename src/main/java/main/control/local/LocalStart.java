package main.control.local;

import CreateSQLParser.TableStructure.CreateTableStructure;
import Utils.DataWriter.*;
import Utils.FileLoader;
import Utils.env_properties;
import Utils.insert.SQLCreaterRunner;
import dataStructure.TableStructure;
import main.control.start;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LocalStart extends start {
    private int basicThreads = Integer.valueOf(env_properties.getEnvironment("nCPU"));
    private int TOTAL_THREADS = Integer.valueOf(env_properties.getEnvironment("TOTAL_THREADS"));
    private String[] createSQLs;
    private String filename;
    private Double localSetNumber;
    private static Scanner scanf = new Scanner(System.in);
    private ExecutorService service;
    private Lock lock = new ReentrantLock();

    public LocalStart(Double linenumber, String SQLFilename) {
        filename=SQLFilename;
        localSetNumber=linenumber;
        checkMsg();
        //根据CPU核心最大值确定线程数量，一般是核心数减一
        service = Executors.newFixedThreadPool(basicThreads);
    }

    @Override
    public void start() {
        List<Exception> exList=new LinkedList<>();
        for (int i = 0; i < createSQLs.length; i++) {
            try {
                TableStructure ts = CreateTableStructure.makeStructure(createSQLs[i] + ';');
                setTableStructure(ts);
                writer = getWriter(ts.getTbname());
                createInsertPool();

                service.shutdown();
                service.awaitTermination(7, TimeUnit.DAYS);
            }
            catch (Exception e){
                Exception msg=new Exception("SQL: '"+createSQLs[i]+"'\n has some error.");
                msg.setStackTrace(e.getStackTrace());
                exList.add(msg);
            }
        }
    }

    @Override
    public void createInsertPool() throws CloneNotSupportedException {
        for (int loop = 0; loop < TOTAL_THREADS; loop++)
            service.execute(new SQLCreaterRunner(
                    (TableStructure) ts.clone(),
                    linenumber[loop],
                    this));
    }

    private void checkMsg(){
        String FileString;

        if (filename == null) {
            System.out.println("输入create SQL");
            FileString = scanf.nextLine();
        } else {
            try {
                FileString = FileLoader.loadFile(new File(filename));
            } catch (IOException e) {
                e.printStackTrace();
                return ;
            }
        }
        if (localSetNumber == null) {
            System.out.println("输入create number");
            localSetNumber = scanf.nextDouble();
        }
        createSQLs = FileString.replace("\r", "").split(";");
        super.setLineNumber(localSetNumber);
    }

    @Override
    public void send(String str) {
        lock.lock();
        try {
            writer.WriteLine(str);
        }
        finally {
            lock.unlock();
        }
    }

    @Override
    protected <T> tF getWriter(T obj) throws IOException {
        String filename = env_properties.getEnvironment("baseFileDir") + obj + "." + env_properties.getEnvironment("toDB");
        if (env_properties.getEnvironment("toDB").equals("jdbc")) {
            return new textFileJDBC();
        } else switch(env_properties.getEnvironment("WriterEngine")){
            case "apache":
                return new ApacheFileWriter(filename);
            case "screenout":
                return new SystemoutWriter();
            default :
                return new textFileWriter(filename);
        }
    }
}
