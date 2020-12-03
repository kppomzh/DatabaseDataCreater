package Utils.DataWriter;

import org.xerial.snappy.SnappyOutputStream;

import java.io.BufferedOutputStream;
import java.io.IOException;

public class netCompressWriter extends Writer {
    private BufferedOutputStream bos;
    private SnappyOutputStream compress;

    public netCompressWriter() throws IOException {
        super();
//        bos =new BufferedOutputStream();
//        compress=new SnappyOutputStream();
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

        return true;
    }

    @Override
    public void close() throws IOException {
        this.bos.close();
    }
}
