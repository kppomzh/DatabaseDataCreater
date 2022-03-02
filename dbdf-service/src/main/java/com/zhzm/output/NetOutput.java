package com.zhzm.output;

import org.apache.commons.lang3.ArrayUtils;
import org.smartboot.socket.transport.AioSession;

import java.io.IOException;

public class NetOutput implements tF {
    private static final byte EOF=-1;
    private final AioSession session;

    public NetOutput(AioSession session) {
        this.session = session;
    }

    @Override
    public void WriteLine(String content) {
        byte[] blength= intToByteArray(content.length());
        synchronized (session) {
            try {
                session.writeBuffer().writeAndFlush(ArrayUtils.addAll(blength,content.getBytes()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static byte[] intToByteArray(int i) {
        byte[] result = new byte[5];
        result[0] = (byte)((i >> 24) & 0xFF);
        result[1] = (byte)((i >> 16) & 0xFF);
        result[2] = (byte)((i >> 8) & 0xFF);
        result[3] = (byte)(i & 0xFF);
        result[4] = EOF;
        return result;
    }
}
