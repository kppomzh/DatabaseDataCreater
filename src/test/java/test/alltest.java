package test;

import main.Service;

import java.io.File;

//这里除了参数是手动写死的之外其他部分和正式的没有区别
public class alltest {
    final static int ci=10;
    public static void main(String[] ar) throws Exception {
        double all=0;
        for(int loop=0;loop<ci;loop++) {
            long time = System.currentTimeMillis();

//        Service.main(new String[]{"-n","20000000","-f","zhaohuang.sql","-a","-o","E:/"});
            Service.main(new String[]{"-n", "5000000", "-f", "zhaohuang.sql"});
//        Service.main(new String[]{"-h"});
            all=all+(System.currentTimeMillis()-time)/1000.0/60.0;
            System.out.println("loop"+loop+":"+(System.currentTimeMillis()-time));
        }
        System.out.println(all/ci+" min");
    }
}
