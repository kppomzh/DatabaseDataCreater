package test;

import com.zhzm.service.LocalServer;
import com.zhzm.utils.BaseEnvironment;

import java.io.IOException;
import java.sql.SQLException;

public class testFunc {
    public static void setLocalEnv(int insertnum){
        BaseEnvironment.setEnvironment("longerInsertNumber",String.valueOf(insertnum));
        BaseEnvironment.setEnvironment("toDB","sql");
        BaseEnvironment.setEnvironment("Optimal","false");
        BaseEnvironment.setEnvironment("TOTAL_THREADS","6");
        BaseEnvironment.setEnvironment("defaultProportion","0.5");
        BaseEnvironment.setEnvironment("canbeNegative","false");
        BaseEnvironment.setEnvironment("longerInsert","true");
        BaseEnvironment.setEnvironment("baseFileDir","F:/");
    }

    public static void PerformanceBase(int ci, int createnum) throws SQLException, IOException {
        double all = 0;

        //虚拟机预热数据
        {
            LocalServer.main(new String[]{"-n", "10000", "-f", "../zhaohuang.sql"});
//            if (BaseEnvironment.getEnvironment("toDB").equals("jdbc")) {
//                getConn conn = new getConn();
//                conn.Stmt().executeUpdate("truncate table zhzm_dbdf_test");
//            }
        }

        for (int loop = 0; loop < ci; loop++) {
            all = all + testBase(createnum,"../zhaohuang.sql");
        }
        System.out.print("insertnum:");
        System.out.println(BaseEnvironment.getEnvironment("longerInsertNumber"));
        System.out.println("avg:" + all / ci + " min");
    }

    public static double testBase(int createnum, String file) throws SQLException, IOException {
        long time = System.currentTimeMillis();

        LocalServer.main(new String[]{"-n", String.valueOf(createnum), "-f", file});
        time = System.currentTimeMillis() - time;
        System.out.println("this" + ":" + time);

//        if (BaseEnvironment.getEnvironment("toDB").equals("jdbc")) {
//            getConn conn = new getConn();
//            conn.Stmt().executeUpdate("truncate table zhzm_dbdf_test");
//        }

        return time / 1000.0 / 60.0;
    }
}
