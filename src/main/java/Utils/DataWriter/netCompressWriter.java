package Utils.DataWriter;

import dataStructure.RuntimeEnvironment;
import org.xerial.snappy.SnappyOutputStream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class netCompressWriter extends BaseWriter {
    private ByteArrayOutputStream bos;
    private SnappyOutputStream compress;

    public netCompressWriter() {
        bos=new ByteArrayOutputStream();
        compress=new SnappyOutputStream(bos);
    }

    @Override
    public boolean WriteLine(String insert) {
        byte[] toCompress=insert.getBytes();
        try {
            compress.write(toCompress);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return bos.size()>6553600;
    }

    @Override
    public void close() throws IOException {
        this.compress.close();
    }

    public byte[] getCompress() throws IOException {
        compress.flush();
        byte[] res=bos.toByteArray();
        bos.reset();
        return res;
    }
}
