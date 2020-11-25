package Utils.DataWriter;

import Utils.env_properties;
import org.apache.commons.io.output.FileWriterWithEncoding;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

public class textFileWriter extends tF{
    private Writer bw;

    public textFileWriter(String Filename) throws IOException {
        super(Filename);
        Writer writer=new FileWriterWithEncoding(textfile,env_properties.getEnvirmentCharset());
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
