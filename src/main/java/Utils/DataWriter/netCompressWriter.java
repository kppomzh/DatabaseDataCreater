package Utils.DataWriter;

import org.smartboot.socket.transport.AioSession;
import org.xerial.snappy.SnappyOutputStream;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;

public class netCompressWriter extends BaseWriter {
    private ByteArrayOutputStream bos;
    private SnappyOutputStream compress;
    private AioSession session;

    public netCompressWriter(TransferQueue<String> cache,AioSession session) {
        super.writeCache=cache;
        bos=new ByteArrayOutputStream();
        compress=new SnappyOutputStream(bos);
        this.session=session;
    }

    @Override
    public void WriteLine() {
        try {
            byte[] toCompress=writeCache.poll(5, TimeUnit.SECONDS).getBytes();
            compress.write(toCompress);

            if(bos.size()>=6553600){
                session.writeBuffer().write(getCompress());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() throws IOException {
        super.close();
        this.compress.close();
    }

    private byte[] getCompress() throws IOException {
        compress.flush();
        byte[] res=bos.toByteArray();
        bos.reset();
        return res;
    }
}
