package com.zhzm.client.writer;

import java.io.File;
import java.io.IOException;

public abstract class tF {
    protected File textfile;

    protected tF(String Filename) throws IOException {
        textfile = new File(Filename);
        if (!textfile.exists()) {
            textfile.createNewFile();
        } else if (textfile.canWrite() || textfile.isFile())
            ;
        else
            throw new IOException(textfile.getPath() + "can't be write.");
    }

    protected tF() {
    }

    public abstract boolean WriteLine(String insert);

    public void close() throws Exception{}
}
