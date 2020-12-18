package main;

import Utils.BaseProperties;
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
                    BaseProperties.setEnvironment(args[loop + 1], args[loop + 2]);
                    loop += 2;
                    break;
                case "-o":
                    BaseProperties.setEnvironment("baseFileDir", args[loop + 1]);
                    loop++;
                    break;
                case "-t":
                    BaseProperties.setEnvironment("totalThreads", args[loop + 1]);
                    loop++;
                    break;
                case "-i":
                    BaseProperties.setEnvironment("toDB", args[loop + 1]);
                    loop++;
                    break;
                case "-h":
                    help.printHelpMessage();
                    System.exit(0);
                case "-O":
                    BaseProperties.setEnvironment("optimal", "true");
                    break;
                case "-I":
                    BaseProperties.setEnvironment("networkService", "true");
                    break;
                case "-L":
                    BaseProperties.setEnvironment("longerInsert", "true");
                    break;
                case "-N":
                    BaseProperties.setEnvironment("canbeNegative", "true");
                    break;
                case "-v":
//                case "-version":
                    help.printVersion();
                    System.exit(0);
            }
        }

        if (BaseProperties.getEnvironment("networkService").equals("true")) {
            service=new NetworkStart();
        } else {
            service = new LocalStart(linenumber,filename);
        }
        service.start();
    }
}
