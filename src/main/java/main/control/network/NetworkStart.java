package main.control.network;

import NetworkUtils.InsertProcessor;
import NetworkUtils.JsonProtocol;
import Utils.DataWriter.Writer;
import Utils.DataWriter.netCompressWriter;
import Utils.env_properties;
import main.control.start;
import org.smartboot.socket.transport.AioQuickServer;

import java.io.IOException;
import java.util.HashMap;

public class NetworkStart extends start {
    private JsonProtocol protocol;
    private InsertProcessor processor;
    private AioQuickServer server;

    public NetworkStart() throws IOException {
        processor=new InsertProcessor(this);
        protocol=new JsonProtocol(this);

        server = new AioQuickServer(
                Integer.valueOf(env_properties.getEnvironment("networkPort")),
                protocol,processor
        );
    }

    private void msgConfig(HashMap<String,String> configure){

    }

    @Override
    public void start() throws IOException {
        server.start();
    }

    @Override
    public void createInsertPool() {

    }

    @Override
    public void send(String str) {

    }

    @Override
    protected <T> Writer getWriter(T obj) throws IOException {
        return new netCompressWriter();
    }
}
