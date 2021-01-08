package main.control.network;

import NetworkUtils.InsertProcessor;
import NetworkUtils.JsonProtocol;
import Utils.BaseProperties;
import main.control.start;
import org.smartboot.socket.transport.AioQuickServer;

import java.io.IOException;

public class NetworkStart extends start {
    private JsonProtocol protocol;
    private InsertProcessor processor;
    private AioQuickServer server;

    public NetworkStart() throws IOException {
        protocol=new JsonProtocol();
        processor=new InsertProcessor();

        server = new AioQuickServer(
                Integer.valueOf(BaseProperties.getEnvironment("networkPort")),
                protocol,processor
        );
    }

    @Override
    public void startService() throws IOException {
        server.start();
    }
}
