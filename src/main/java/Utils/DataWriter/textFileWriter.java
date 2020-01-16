package Utils.DataWriter;

import Utils.env_properties;

import java.io.*;

public class textFileWriter extends tF{
    private BufferedOutputStream bos;
    private BufferedWriter bw;

    public textFileWriter(String Filename) throws IOException {
        super(Filename);
        bos = new BufferedOutputStream(new FileOutputStream(textfile, false), 32768);//now 32768 is best
        //
        bw = new BufferedWriter(new OutputStreamWriter(bos, env_properties.getEnvirmentCharset()), 32768);//now 32768 is best
    }

    @Override
    public synchronized boolean WriteLine(String insert) {
        try {
            bw.write(insert);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void closeWriter() throws IOException {
        bw.flush();
        bw.close();
    }
}
