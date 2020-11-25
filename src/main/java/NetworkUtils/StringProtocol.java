package NetworkUtils;

import org.smartboot.socket.Protocol;
import org.smartboot.socket.transport.AioSession;

import java.nio.ByteBuffer;

public class StringProtocol implements Protocol {


    @Override
    public Object decode(ByteBuffer readBuffer, AioSession aioSession) {
        byte length = readBuffer.get(readBuffer.position());
        if (length+1 < readBuffer.remaining()) {
            return null;
        }
        byte[] b = new byte[readBuffer.get()];
        readBuffer.get(b);
        return new String(b);
    }
}
