package test;

import main.Service;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

//这里除了参数是手动写死的之外其他部分和正式的没有区别
public class alltest {
    final static int ci=1;
    public static void main(String[] ar) throws Exception {
        double all=0;
        for(int loop=0;loop<ci;loop++) {
            long time = System.currentTimeMillis();

//        Service.main(new String[]{"-n","20000000","-f","f:/create.sql","-a","-o","E:/"});
            Service.main(new String[]{"-n", "5000000", "-f", "zhaohuang.sql", "-i", "csv"});
//        Service.main(new String[]{"-h"});
            all=all+(System.currentTimeMillis()-time)/1000.0/60.0;
        }
        System.out.println(all/ci+" min");
    }

    @Test
    public void readfile() throws IOException {
        System.out.print(FileUtils.readFileToString(new File("pom.xml"),"utf-8"));
    }
}
