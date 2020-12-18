package Utils.DataWriter;

import Utils.BaseProperties;
import dataStructure.RuntimeEnvironment;
import org.apache.commons.io.output.WriterOutputStream;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class ApacheFileWriter extends BaseWriter {
    private WriterOutputStream bw;

    public ApacheFileWriter(String Filename, RuntimeEnvironment env) throws IOException {
        super(Filename,env);
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(textfile, false), 32768);
        //暂定512K缓存，一般硬盘测试的中等数据块
        bw = new WriterOutputStream(new OutputStreamWriter(bos), super.env.getEnvirmentCharset(),32768,false);
    }

    @Override
    public boolean WriteLine(String insert) {
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
