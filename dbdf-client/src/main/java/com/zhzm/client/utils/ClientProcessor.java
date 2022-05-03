package com.zhzm.client.utils;

import com.zhzm.client.writer.ApacheFileWriter;
import org.smartboot.socket.MessageProcessor;
import org.smartboot.socket.StateMachineEnum;
import org.smartboot.socket.transport.AioSession;
import com.zhzm.client.writer.tF;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ClientProcessor implements MessageProcessor<String> {
    private String writeType;
    private File fileDir;
    private Map<String,tF> mapWriter;

    public ClientProcessor(String writeType, String outputDir) throws IOException {
        this.writeType = writeType;
        fileDir=new File(outputDir);
        if(!fileDir.exists()){
            fileDir.mkdirs();
        }
        else if(!fileDir.isDirectory()){
            throw new IOException("无法写入非文件夹的文件中。");
        }
        mapWriter=new HashMap<>();
    }

    @Override
    public void process(AioSession aioSession, String data) {

//        writer=new ApacheFileWriter()
    }

    @Override
    public void stateEvent(AioSession session, StateMachineEnum stateMachineEnum, Throwable throwable) {
        MessageProcessor.super.stateEvent(session, stateMachineEnum, throwable);
    }
}
