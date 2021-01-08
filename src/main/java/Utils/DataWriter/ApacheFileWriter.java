package Utils.DataWriter;

import dataStructure.RuntimeEnvironment;
import org.apache.commons.io.output.WriterOutputStream;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;

public class ApacheFileWriter extends BaseWriter {
    private WriterOutputStream bw;

    public ApacheFileWriter(String Filename, RuntimeEnvironment env, TransferQueue<String> cache) throws IOException {
        super(Filename,env,cache);
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(textfile, false), 32768);
        //暂定512K缓存，一般硬盘测试的中等数据块
        bw = new WriterOutputStream(new OutputStreamWriter(bos), super.env.getEnvirmentCharset(),32768,false);
    }

    @Override
    public void WriteLine() {
        try {
            bw.write(writeCache.poll(5, TimeUnit.SECONDS).getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() throws IOException {
        super.close();
        bw.flush();
        bw.close();
    }
}
