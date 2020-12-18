package Client.CLI;

import NetworkUtils.InsertProcessor;
import NetworkUtils.JsonProtocol;
import Utils.BaseProperties;
import Utils.Record.RuntimeEnvironment;
import org.smartboot.socket.transport.AioQuickClient;
import org.smartboot.socket.transport.AioSession;

import java.io.IOException;

public class Client {
    public static void main(String[] args) throws IOException {
        RuntimeEnvironment environment=BaseProperties.getEnvironment();

        AioQuickClient<Integer> aioQuickClient = new AioQuickClient<Integer>
                (environment.getServerHost(), environment.getServerPort(), new JsonProtocol(), new InsertProcessor());
        AioSession session = aioQuickClient.start();
        session.writeBuffer().writeInt(1);

        aioQuickClient.shutdown();
    }
}
