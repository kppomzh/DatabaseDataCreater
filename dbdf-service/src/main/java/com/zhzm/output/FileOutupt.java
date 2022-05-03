package com.zhzm.output;

import com.zhzm.utils.BaseEnvironment;
import org.apache.commons.io.output.WriterOutputStream;

import java.io.*;

public class FileOutupt implements tF {
    private final WriterOutputStream bw;
    private final String textfile;

    public FileOutupt(String Filename) throws IOException {
        String baseFileDir=BaseEnvironment.getEnvironment("baseFileDir","./");
        File fileDir=new File(baseFileDir);
        if(!fileDir.exists()){
            fileDir.mkdirs();
        }
        else if(!fileDir.isDirectory()){
            throw new IOException("无法写入非文件夹的文件中。");
        }
        baseFileDir=fileDir.getPath();
        textfile=baseFileDir+'/'+Filename;
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(textfile, false), 32768);
        //暂定512K缓存，一般硬盘测试的中等数据块
        bw = new WriterOutputStream(new OutputStreamWriter(bos), BaseEnvironment.getEnvirmentCharset(),32768,false);
    }

    @Override
    public void WriteLine(String insert) {
        synchronized (bw) {
            try {
                bw.write(insert.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void close() throws IOException {
        bw.flush();
        bw.close();
    }
}
