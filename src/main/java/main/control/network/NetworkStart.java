package main.control.network;

import NetworkUtils.InsertProcessor;
import NetworkUtils.StringProtocol;
import Utils.DataWriter.tF;
import Utils.env_properties;
import dataStructure.TableStructure;
import main.control.start;
import org.smartboot.socket.transport.AioQuickServer;

import java.io.IOException;

public class NetworkStart extends start {
    public NetworkStart() throws IOException {
        AioQuickServer<String> server = new AioQuickServer<String>(
                Integer.valueOf(env_properties.getEnvironment("networkPort")),
                new StringProtocol(),
                new InsertProcessor(this)
        );
        server.start();
    }

    private void msgConfig(){

    }

    @Override
    public void start() throws IOException {

    }

    @Override
    public void createInsertPool() {

    }

    @Override
    public void send(String str) {

    }

    @Override
    protected <T> tF getWriter(T obj) throws IOException {
        return null;
    }
}
