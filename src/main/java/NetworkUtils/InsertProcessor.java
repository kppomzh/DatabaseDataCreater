package NetworkUtils;

import CreateSQLParser.TableStructure.CreateTableStructure;
import Utils.DataWriter.*;
import Utils.BaseProperties;
import Utils.insert.SQLCreaterRunner;
import dataStructure.RuntimeEnvironment;
import dataStructure.TableStructure;
import main.control.start;
import org.smartboot.socket.MessageProcessor;
import org.smartboot.socket.StateMachineEnum;
import org.smartboot.socket.transport.AioSession;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class InsertProcessor extends start implements MessageProcessor<RuntimeEnvironment> {
    private int basicThreads = Integer.valueOf(BaseProperties.getEnvironment("nCPU"));
    private int TOTAL_THREADS = Integer.valueOf(BaseProperties.getEnvironment("totalThreads"));

    private ExecutorService service;
    private Lock lock = new ReentrantLock();

    private LinkedBlockingQueue sessions = new LinkedBlockingQueue();
    private AioSession session;
    private RuntimeEnvironment thisEnv;
    private netCompressWriter writer;

    public InsertProcessor(){
        service = Executors.newFixedThreadPool(basicThreads);
        writer=new netCompressWriter();
    }

    @Override
    public void process(AioSession aioSession, RuntimeEnvironment environment) {
        session=aioSession;
        thisEnv=environment;
        List<Exception> exList = new LinkedList<>();
        String[] createSQLs = thisEnv.getSQLString().replace("\r", "").split(";");
        for (int i = 0; i < createSQLs.length; i++) {
            try {
                TableStructure ts = CreateTableStructure.makeStructure(createSQLs[i] + ';', thisEnv);
                setTableStructure(ts);
                createInsertPool();

                service.shutdown();
                service.awaitTermination(7, TimeUnit.DAYS);
            } catch (Exception e) {
                Exception msg = new Exception("SQL: '" + createSQLs[i] + "'\n has some error.");
                msg.setStackTrace(e.getStackTrace());
                exList.add(msg);
            }
        }



    }



    @Override
    public void stateEvent(AioSession aioSession, StateMachineEnum stateMachineEnum, Throwable throwable) {
        switch (stateMachineEnum){
            case NEW_SESSION:
                sessions.add(aioSession);
                break;
            case DECODE_EXCEPTION:
            case SESSION_CLOSING:
                sessions.remove(aioSession);
                break;
        }
    }

    @Override
    public void start() throws IOException {

    }

    @Override
    protected void createInsertPool() throws CloneNotSupportedException {
        super.setLineNumber(thisEnv.getCreateNum());
        for (int loop = 0; loop < TOTAL_THREADS; loop++)
            service.execute(new SQLCreaterRunner(
                    (TableStructure) ts.clone(),
                    linenumber[loop],
                    this,
                    thisEnv));
    }

    @Override
    public void send(String str) {
        lock.lock();
        if(writer.WriteLine(str)) {
            try {
                session.writeBuffer().writeAndFlush(writer.getCompress());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        lock.unlock();
    }
}
