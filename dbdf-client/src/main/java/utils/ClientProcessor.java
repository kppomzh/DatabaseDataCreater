package utils;

import org.smartboot.socket.MessageProcessor;
import org.smartboot.socket.StateMachineEnum;
import org.smartboot.socket.transport.AioSession;

import java.io.File;
import java.io.IOException;

public class ClientProcessor implements MessageProcessor<String> {
    private String writeType;
    private File fileDir;

    public ClientProcessor(String writeType, String outputDir) throws IOException {
        this.writeType = writeType;
        fileDir=new File(outputDir);
        if(!fileDir.exists()){
            fileDir.mkdirs();
        }
        else if(!fileDir.isDirectory()){
            throw new IOException("无法写入非文件夹的文件中。");
        }
    }

    @Override
    public void process(AioSession aioSession, String s) {
        
    }

    @Override
    public void stateEvent(AioSession session, StateMachineEnum stateMachineEnum, Throwable throwable) {
        MessageProcessor.super.stateEvent(session, stateMachineEnum, throwable);
    }
}
