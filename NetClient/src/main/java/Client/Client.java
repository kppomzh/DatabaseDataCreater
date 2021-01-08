package Client;

import Client.CLI.cliClient;
import Client.GUI.guiClient;
import Utils.BaseProperties;

public abstract class Client {
    public static void main(String[] args) throws Exception {
        String filename = null,linenumber = null;
        Client client;
        boolean isGUI=true;

        outer:
        for (int loop = 0; loop < args.length; loop++) {
            switch (args[loop]) {
                case "-f":
                    filename = args[loop + 1];
                    loop++;
                    break;
                case "-n":
                    linenumber = args[loop + 1];
                    loop++;
                    break;
                case "-o":
                    BaseProperties.setEnvironment("saveFileDir", args[loop + 1]);
                    loop++;
                    break;
                case "-O":
                    BaseProperties.setEnvironment("optimal", "true");
                    break;
                case "-c": case "--cli":
                    isGUI=false;
                    break;
//                case "-v":
//                case "-version":
//                    help.printVersion();
//                    System.exit(0);
            }
        }

        client=isGUI?new guiClient():new cliClient();
        client.start(filename,linenumber);
    }

    public abstract void start(String filename, String linenumber) throws Exception;
}
