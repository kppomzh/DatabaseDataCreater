package Utils.DataWriter;

import dataStructure.RuntimeEnvironment;
import org.apache.commons.io.output.FileWriterWithEncoding;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;


public class textFileWriter extends BaseWriter {
    private Writer bw;

    public textFileWriter(String Filename, RuntimeEnvironment env, TransferQueue<String> cache) throws IOException {
        super(Filename,env,cache);
        Writer writer=new FileWriterWithEncoding(textfile, super.env.getEnvirmentCharset());
        bw = new BufferedWriter(writer, 32768);//now 32768 is best
    }

    @Override
    public void WriteLine() {
        try {
            bw.write(writeCache.poll(5, TimeUnit.SECONDS));
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
