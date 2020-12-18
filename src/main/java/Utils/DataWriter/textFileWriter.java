package Utils.DataWriter;

import Utils.BaseProperties;
import dataStructure.RuntimeEnvironment;
import org.apache.commons.io.output.FileWriterWithEncoding;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;


public class textFileWriter extends BaseWriter {
    private Writer bw;

    public textFileWriter(String Filename, RuntimeEnvironment env) throws IOException {
        super(Filename,env);
        Writer writer=new FileWriterWithEncoding(textfile, super.env.getEnvirmentCharset());
        bw = new BufferedWriter(writer, 32768);//now 32768 is best
    }

    @Override
    public boolean WriteLine(String insert) {
        try {
            bw.write(insert);
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
