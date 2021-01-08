package Utils.DataWriter;

import dataStructure.RuntimeEnvironment;

import java.io.File;
import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TransferQueue;

public abstract class BaseWriter implements Runnable {
    protected File textfile;
    protected RuntimeEnvironment env;
    protected boolean notStop;
    protected TransferQueue<String> writeCache;

    protected BaseWriter(String Filename, RuntimeEnvironment env, TransferQueue<String> cache) throws IOException {
        this(env,cache);
        textfile = new File(Filename);
        if (!textfile.exists()) {
            textfile.createNewFile();
        } else if (textfile.canWrite() || textfile.isFile())
            ;
        else
            throw new IOException(textfile.getPath() + "can't be write.");
    }

    protected BaseWriter(RuntimeEnvironment env,TransferQueue<String> cache) {
        this.env=env;
        notStop=true;
        writeCache=cache;
    }

    protected BaseWriter() {
    }

    public abstract void WriteLine();

    public void close() throws IOException {
        notStop=false;
    }

    @Override
    public void run() {
        while(notStop){
            WriteLine();
        }
    }
}
