package main;

import Utils.env_properties;
import main.control.local.LocalStart;
import main.control.network.NetworkStart;
import main.control.start;

import java.io.IOException;
import java.util.Scanner;

public class Service {
    private static Scanner scanf = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        start service;
        String filename = null,linenumber = null;
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
                case "--set":
                    env_properties.setEnvironment(args[loop + 1], args[loop + 2]);
                    loop += 2;
                    break;
                case "-o":
                    env_properties.setEnvironment("baseFileDir", args[loop + 1]);
                    loop++;
                    break;
                case "-t":
                    env_properties.setEnvironment("totalThreads", args[loop + 1]);
                    loop++;
                    break;
                case "-i":
                    env_properties.setEnvironment("toDB", args[loop + 1]);
                    loop++;
                    break;
                case "-h":
                    help.printHelpMessage();
                    System.exit(0);
                case "-O":
                    env_properties.setEnvironment("optimal", "true");
                    break;
                case "-I":
                    env_properties.setEnvironment("networkService", "true");
                    break;
                case "-L":
                    env_properties.setEnvironment("longerInsert", "true");
                    break;
                case "-N":
                    env_properties.setEnvironment("canbeNegative", "true");
                    break;
                case "-v":
//                case "-version":
                    help.printVersion();
                    System.exit(0);
            }
        }

        if (env_properties.getEnvironment("networkService").equals("true")) {
            service=new NetworkStart();
        } else {
            service = new LocalStart(linenumber,filename);
        }
        service.start();
    }
}
