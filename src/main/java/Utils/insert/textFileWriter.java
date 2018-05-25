package Utils.insert;

import java.io.*;

public class textFileWriter  implements tF{
    private File textfile;
    private long writenum;
    private BufferedOutputStream bos;

    public textFileWriter(String Filename) throws IOException {
        textfile=new File(Filename);
        if(!textfile.exists()) {
            textfile.createNewFile();
        }
        else if(textfile.canWrite()||textfile.isFile())
            ;
        else
            throw new IOException(textfile.getPath()+"can't be write.");

        bos=new BufferedOutputStream(new FileOutputStream(textfile,false),5242880);
        //暂定5M缓存
        writenum=0;
    }
    @Override
    public synchronized boolean WriteLine(String insert) {
        try {
            bos.write(insert.getBytes());
            bos.write("\r\n".getBytes());
//            System.out.println(textfile.getName()+' '+writenum++);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public void closeWriter() throws IOException {
        bos.close();
    }
}
