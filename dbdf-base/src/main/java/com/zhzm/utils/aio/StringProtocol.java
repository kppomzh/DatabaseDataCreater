package com.zhzm.utils.aio;

import com.zhzm.exceptions.NetworkSendError;
import org.smartboot.socket.Protocol;
import org.smartboot.socket.transport.AioSession;

import java.nio.ByteBuffer;
import java.util.Arrays;

public class StringProtocol implements Protocol<String> {
    @Override
    public String decode(ByteBuffer byteBuffer, AioSession session) {
        byte[] b = new byte[byteBuffer.get()];//3
        byteBuffer.get(b);//4
        try {
            if (b.length < 6) throw new NetworkSendError(-1);
            if (b[4] != (byte) -1) throw new NetworkSendError(-2);
            int blength = byteArrayToInt(Arrays.copyOf(b, 4));
            if (blength != b.length + 5) throw new NetworkSendError(-3);
        } catch (NetworkSendError e) {
            e.printStackTrace();
            return "";
        }

        return new String(Arrays.copyOfRange(b, 5, b.length));//5
    }

    private static int byteArrayToInt(byte[] bytes) {
        int value = 0;
        for (int i = 0; i < 4; i++) {
            int shift = (3 - i) * 8;
            value += (bytes[i] & 0xFF) << shift;
        }
        return value;
    }
}
