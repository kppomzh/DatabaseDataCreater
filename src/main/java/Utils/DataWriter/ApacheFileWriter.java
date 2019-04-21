package Utils.DataWriter;

import org.apache.commons.io.output.WriterOutputStream;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

public class ApacheFileWriter extends tF {
    private BufferedOutputStream bos;
    private WriterOutputStream bw;

    public ApacheFileWriter(String Filename, String charset) throws IOException {
        super(Filename);
        bos = new BufferedOutputStream(new FileOutputStream(textfile, false), 524288);
        //暂定512K缓存，一般硬盘测试的中等数据块
        bw = new WriterOutputStream(new OutputStreamWriter(bos), Charset.forName("utf-8"));
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
    public void closeWriter() throws IOException {
        bw.flush();
        bw.close();
    }
}
