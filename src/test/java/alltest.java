import Utils.datastruc.CreateTableStruc;
import Utils.datastruc.Fileloader;
import Utils.env_properties;
import Utils.insert.CreateInsertSQLFile;
import Utils.insert.CreateInsertSQLJDBC;
import Utils.insert.textFileJDBC;
import dataStruture.TableStructure;

import java.io.File;

//这里除了参数是手动写死的之外其他部分和正式的没有区别
public class alltest {
    public static void main(String[] ar) throws Exception {
        long time=System.currentTimeMillis();

//        Service.main(new String[]{"-n","20000000","-f","f:/create.txt","-a","-o","E:/"});
//        Service.main(new String[]{"-n","500","-f","E:\\Work\\K18\\数据\\zhaohuang.txt"});
        Service.main(new String[]{"-h"});

        System.out.println(((System.currentTimeMillis()-time)/1000.0)/60.0+" min");
    }
}
