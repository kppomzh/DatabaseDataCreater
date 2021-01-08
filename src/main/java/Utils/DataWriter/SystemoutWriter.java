package Utils.DataWriter;

import dataStructure.RuntimeEnvironment;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;

public class SystemoutWriter extends BaseWriter {
    public SystemoutWriter(RuntimeEnvironment env, TransferQueue<String> cache) {
        super(env,cache);
    }

    @Override
    public void WriteLine() {
        try {
            System.out.println(writeCache.poll(5,TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while(notStop) {
            try {
                System.out.println(writeCache.poll(5, TimeUnit.SECONDS));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
