package Utils.DataWriter;

import java.io.*;

public class textFileWriter extends tF{
    private BufferedOutputStream bos;
    private BufferedWriter bw;

    public textFileWriter(String Filename) throws IOException {
        super(Filename);
        bos = new BufferedOutputStream(new FileOutputStream(textfile, false), 524288);
        //暂定512K缓存，一般硬盘测试的中等数据块
        bw = new BufferedWriter(new OutputStreamWriter(bos), 524288);
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
