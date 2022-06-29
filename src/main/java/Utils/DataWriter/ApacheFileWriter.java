package Utils.DataWriter;

import Utils.baseEnvironment;
import org.apache.commons.io.output.WriterOutputStream;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class ApacheFileWriter extends tF {
    private WriterOutputStream bw;

    public ApacheFileWriter(String Filename) throws IOException {
        super(Filename);
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(textfile, false), 32768);
        //暂定512K缓存，一般硬盘测试的中等数据块
        bw = new WriterOutputStream(new OutputStreamWriter(bos), baseEnvironment.getEnvirmentCharset(),32768,false);
    }

    @Override
    public synchronized boolean WriteLine(String insert) {
        try {
            bw.write(insert.getBytes());
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void close() throws IOException {
        bw.flush();
        bw.close();
    }
}
