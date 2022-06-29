package test;

import Utils.DBConn.getConn;
import Utils.baseEnvironment;
import main.Service;

import java.sql.SQLException;

public class testFunc {
    public static void setLocalEnv(int insertnum){
        baseEnvironment.setEnvironment("longerInsertNumber",String.valueOf(insertnum));
        baseEnvironment.setEnvironment("toDB","sql");
        baseEnvironment.setEnvironment("Optimal","false");
        baseEnvironment.setEnvironment("TOTAL_THREADS","6");
        baseEnvironment.setEnvironment("defaultProportion","0.5");
        baseEnvironment.setEnvironment("canbeNegative","false");
        baseEnvironment.setEnvironment("longerInsert","true");
        baseEnvironment.setEnvironment("baseFileDir","F:/");
    }

    public static void PerformanceBase(int ci, int createnum) throws SQLException {
        double all = 0;

        //虚拟机预热数据
        {
            Service.main(new String[]{"-n", "10000", "-f", "./zhaohuang.sql"});
            if (baseEnvironment.getEnvironment("toDB").equals("jdbc")) {
                getConn conn = new getConn();
                conn.Stmt().executeUpdate("truncate table zhzm_dbdf_test");
            }
        }

        for (int loop = 0; loop < ci; loop++) {
            all = all + testBase(createnum,"./zhaohuang.sql");
        }
        System.out.print("insertnum:");
        System.out.println(baseEnvironment.getEnvironment("longerInsertNumber"));
        System.out.println("avg:" + all / ci + " min");
    }

    public static double testBase(int createnum, String file) throws SQLException {
        long time = System.currentTimeMillis();

        Service.main(new String[]{"-n", String.valueOf(createnum), "-f", file});
        time = System.currentTimeMillis() - time;
        System.out.println("this" + ":" + time);

        if (baseEnvironment.getEnvironment("toDB").equals("jdbc")) {
            getConn conn = new getConn();
            conn.Stmt().executeUpdate("truncate table zhzm_dbdf_test");
        }

        return time / 1000.0 / 60.0;
    }
}
