package Utils.DataWriter;

import dataStructure.RuntimeEnvironment;

import java.io.File;
import java.io.IOException;

public abstract class BaseWriter {
    protected File textfile;
    protected RuntimeEnvironment env;

    protected BaseWriter(String Filename, RuntimeEnvironment env) throws IOException {
        this(env);
        textfile = new File(Filename);
        if (!textfile.exists()) {
            textfile.createNewFile();
        } else if (textfile.canWrite() || textfile.isFile())
            ;
        else
            throw new IOException(textfile.getPath() + "can't be write.");
    }

    protected BaseWriter(RuntimeEnvironment env) {
        this.env=env;
    }

    protected BaseWriter() {
    }

    public abstract boolean WriteLine(String insert);

    public void close() throws Exception{}
}
