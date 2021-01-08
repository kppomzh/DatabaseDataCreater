package Client.CLI;

import Client.Client;
import NetworkUtils.InsertProcessor;
import NetworkUtils.JsonProtocol;
import Utils.BaseProperties;
import Utils.Record.RuntimeEnvironment;
import org.smartboot.socket.transport.AioQuickClient;
import org.smartboot.socket.transport.AioSession;

import java.io.IOException;
import java.util.Scanner;

public class cliClient extends Client {
    static Scanner scanf = new Scanner(System.in);

    public void start(String filename, String linenumber) throws IOException {
        RuntimeEnvironment environment=BaseProperties.getEnvironment();

        AioQuickClient<Integer> aioQuickClient = new AioQuickClient<Integer>
                (environment.getServerHost(), environment.getServerPort(), new JsonProtocol(), new InsertProcessor());
        AioSession session = aioQuickClient.start();

        String SQL=scanf.nextLine();

        session.writeBuffer().writeInt(1);

        aioQuickClient.shutdown();
    }
}
