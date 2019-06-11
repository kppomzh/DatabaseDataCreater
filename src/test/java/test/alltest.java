package test;

import SavingTypeString.DBJdbcLinkString;
import SavingTypeString.DBjdbcDriverString;
import Utils.env_properties;
import main.Service;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//这里除了参数是手动写死的之外其他部分和正式的没有区别
public class alltest {
    final static int ci=10;

    @Test
    public void timetest() throws Exception {
        double all=0;
        for(int loop=0;loop<ci;loop++) {
            long time = System.currentTimeMillis();

            Service.main(new String[]{"-n", "5000000", "-f", "zhaohuang.sql"});
            all=all+(System.currentTimeMillis()-time)/1000.0/60.0;
            System.out.println("loop"+loop+":"+(System.currentTimeMillis()-time));
        }
        System.out.println("avg:"+all/ci+" min");
    }

    @Test
    public void typetest() throws Exception {
        Service.main(new String[]{"-n", "5", "-f", "zhaohuang.sql","-i","sql"});
        Service.main(new String[]{"-n", "5", "-f", "zhaohuang.sql","-i","json"});
        Service.main(new String[]{"-n", "5", "-f", "zhaohuang.sql","-i","csv"});
//        Service.main(new String[]{"-n", "5", "-f", "zhaohuang.sql","-i","mongo"});
    }

//    @Test
//    public void sqltest() throws ClassNotFoundException, SQLException {
//        System.setProperty("jdbc.driver",
//                DBjdbcDriverString.getJdbcDriverString(env_properties.getEnvironment("DBsoftware").toLowerCase()));
//
//        String url= DBJdbcLinkString.getJdbcLinkString(env_properties.getEnvironment("DBsoftware").toLowerCase());
//        Connection conn = DriverManager.getConnection(url.
//                        replace("{IP}",env_properties.getEnvironment("IP")).
//                        replace("{port}",env_properties.getEnvironment("port")).
//                        replace("{dbname}",env_properties.getEnvironment("database")),
//                env_properties.getEnvironment("user"),
//                env_properties.getEnvironment("password"));
//
//        System.out.println(conn.getSchema()!=null);
//    }
}
