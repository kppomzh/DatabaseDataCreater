package NetworkUtils;

import CreateSQLParser.TableStructure.CreateTableStructure;
import Utils.BaseProperties;
import Utils.DataWriter.netCompressWriter;
import Utils.insert.SQLCreaterRunner;
import dataStructure.RuntimeEnvironment;
import dataStructure.TableStructure;
import org.smartboot.socket.MessageProcessor;
import org.smartboot.socket.StateMachineEnum;
import org.smartboot.socket.transport.AioSession;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

public class InsertProcessor implements MessageProcessor<RuntimeEnvironment> {
    private int basicThreads = Integer.valueOf(BaseProperties.getEnvironment("nCPU"));
    private int TOTAL_THREADS = Integer.valueOf(BaseProperties.getEnvironment("totalThreads"));

    private ExecutorService service;

    private LinkedBlockingQueue sessions = new LinkedBlockingQueue();
    private AioSession session;
    private RuntimeEnvironment thisEnv;
    private netCompressWriter writer;
    protected TableStructure ts;
    protected int[] linenumber;
    private TransferQueue<String> writeCache;

    public InsertProcessor(){
        service = Executors.newFixedThreadPool(basicThreads);
        writeCache=new LinkedTransferQueue<>();
        writer=new netCompressWriter(writeCache,session);
    }

    @Override
    public void process(AioSession aioSession, RuntimeEnvironment environment) {
        session=aioSession;

        thisEnv=environment;
        List<Exception> exList = new LinkedList<>();
        String[] createSQLs = thisEnv.getSQLString().replace("\r", "").split(";");
        for (int i = 0; i < createSQLs.length; i++) {
            try {
                ts = CreateTableStructure.makeStructure(createSQLs[i] + ';', thisEnv);
                setLineNumber(thisEnv.getCreateNum());
                setTableStructure();
                createInsertPool();

                service.shutdown();
                service.awaitTermination(7, TimeUnit.DAYS);
            } catch (Exception e) {
                Exception msg = new Exception("SQL: '" + createSQLs[i] + "'\n has some error.");
                msg.setStackTrace(e.getStackTrace());
                exList.add(msg);
            }
        }
        session.writeBuffer().flush();
        session.close(true);
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

    protected void createInsertPool() throws CloneNotSupportedException {
        service.execute(writer);
        for (int loop = 0; loop < TOTAL_THREADS; loop++)
            service.execute(new SQLCreaterRunner(
                    (TableStructure) ts.clone(),
                    linenumber[loop],
                    writeCache,
                    thisEnv));
    }

    public void setTableStructure() {
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
