package com.zhzm.output;

import java.io.IOException;
import java.io.OutputStream;

public class SystemOutput implements tF {
    OutputStream stream=System.out;
    @Override
    public void WriteLine(String content) {
        synchronized(stream) {
            try {
                stream.write(content.getBytes());
                stream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void close() throws IOException {

    }
}
