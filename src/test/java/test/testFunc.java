package test;

import Utils.DBConn.getConn;
import Utils.env_properties;
import main.Service;

import java.io.IOException;
import java.sql.SQLException;

public class testFunc {
    public static void setLocalEnv(int insertnum){
        env_properties.setEnvironment("longerInsertNumber",String.valueOf(insertnum));
        env_properties.setEnvironment("toDB","sql");
        env_properties.setEnvironment("optimal","false");
        env_properties.setEnvironment("totalThreads","12");
        env_properties.setEnvironment("defaultProportion","0.5");
        env_properties.setEnvironment("canbeNegative","false");
        env_properties.setEnvironment("longerInsert","true");
        env_properties.setEnvironment("baseFileDir","E:/");
    }

    public static void PerformanceBase(int ci, int createnum) throws SQLException, IOException {
        double all = 0;

        //虚拟机预热数据
        {
            Service.main(new String[]{"-n", "10000", "-f", "./zhaohuang.sql"});
            if (env_properties.getEnvironment("toDB").equals("jdbc")) {
                getConn conn = new getConn();
                conn.Stmt().executeUpdate("truncate table zhzm_dbdf_test");
            }
        }

        for (int loop = 0; loop < ci; loop++) {
            all = all + testBase(createnum,"./zhaohuang.sql");
        }
        System.out.print("insertnum:");
        System.out.println(env_properties.getEnvironment("longerInsertNumber"));
        System.out.println("avg:" + all / ci + " min");
    }

    public static double testBase(int createnum, String file) throws SQLException, IOException {
        long time = System.currentTimeMillis();

        Service.main(new String[]{"-n", String.valueOf(createnum), "-f", file});
        time = System.currentTimeMillis() - time;
        System.out.println("this" + ":" + time);

        if (env_properties.getEnvironment("toDB").equals("jdbc")) {
            getConn conn = new getConn();
            conn.Stmt().executeUpdate("truncate table zhzm_dbdf_test");
        }

        return time / 1000.0 / 60.0;
    }
}
