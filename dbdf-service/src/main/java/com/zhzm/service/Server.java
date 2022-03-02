package com.zhzm.service;

import com.zhzm.utils.aio.ServerProcessor;
import com.zhzm.utils.aio.StringProtocol;
import org.smartboot.socket.transport.AioQuickServer;

import java.io.IOException;

public class Server {
    public static void main(String[] args) throws IOException {
        // 1
        ServerProcessor processor=new ServerProcessor();
        StringProtocol protocol=new StringProtocol();
        AioQuickServer server = new AioQuickServer(8080, protocol,processor);
        //2
        server.start();
    }
}
