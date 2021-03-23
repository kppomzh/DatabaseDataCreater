package client;

import java.io.IOException;

public class startTest {
    public static void main(String... args){
        String filename = null;
        Integer linenumber = null;
        for (int loop = 0; loop < args.length; loop++) {
            switch (args[loop]) {
                case "-f":
                    filename = args[loop + 1];
                    loop++;
                    break;
                case "-n":
                    linenumber = Integer.valueOf(args[loop + 1]);
                    loop++;
                    break;
                case "-h":
                    help.printHelpMessage();
                    System.exit(0);
            }
        }

        if (filename==null){
            System.out.println("-f can not equal null,exit.");
            System.exit(1);
        }
        else{
            try {
                TestMain test=new TestMain(filename,linenumber);
                test.startTest();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
