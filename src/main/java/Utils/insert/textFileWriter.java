package Utils.insert;

import java.io.*;

public class textFileWriter  implements tF{
    private File textfile;
    private BufferedOutputStream bos;
    private BufferedWriter bw;

    public textFileWriter(String Filename) throws IOException {
        textfile=new File(Filename);
        if(!textfile.exists()) {
            textfile.createNewFile();
        }
        else if(textfile.canWrite()||textfile.isFile())
            ;
        else
            throw new IOException(textfile.getPath()+"can't be write.");

        bos=new BufferedOutputStream(new FileOutputStream(textfile,false),524288);
        //暂定512K缓存，一般硬盘测试的中等数据块
        bw=new BufferedWriter(new OutputStreamWriter(bos),524288);
    }
    @Override
    public synchronized boolean WriteLine(String insert) {
        try {
            bw.write(insert);
            bw.write("\r\n");
//            System.out.println(textfile.getName()+' '+writenum++);
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
