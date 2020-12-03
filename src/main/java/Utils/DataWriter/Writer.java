package Utils.DataWriter;

import java.io.File;
import java.io.IOException;

public abstract class Writer {
    protected File textfile;

    protected Writer(String Filename) throws IOException {
        textfile = new File(Filename);
        if (!textfile.exists()) {
            textfile.createNewFile();
        } else if (textfile.canWrite() || textfile.isFile())
            ;
        else
            throw new IOException(textfile.getPath() + "can't be write.");
    }

    protected Writer() {
    }

    public abstract boolean WriteLine(String insert);

    public void close() throws Exception{}
}
