package Utils.insert;

import java.io.*;

public class textFileWriter  implements tF{
    private File textfile;
    private long writenum;
    private FileOutputStream fos;

    public textFileWriter(String Filename) throws IOException {
        textfile=new File(Filename);
        if(!textfile.exists()) {
            textfile.createNewFile();
        }
        else if(textfile.canWrite()||textfile.isFile())
            ;
        else
            throw new IOException(textfile.getPath()+"can't be write.");

        fos=new FileOutputStream(textfile,false);
        writenum=0;
    }
    @Override
    public synchronized boolean WriteLine(String insert) {
        try {
            fos.write(insert.getBytes());
            fos.write("\r\n".getBytes());
            System.out.println(textfile.getName()+' '+writenum++);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    public void closeWriter() throws IOException {
        fos.flush();
        fos.close();
    }
}
