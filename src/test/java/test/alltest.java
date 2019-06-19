package test;

import Utils.DBConn.getConn;
import main.Service;
import org.junit.Test;

import java.sql.SQLException;

//这里除了参数是手动写死的之外其他部分和正式的没有区别
public class alltest {
    final static int ci=10;

    @Test
    public void timetest() throws SQLException {
        double all=0;
        for(int loop=0;loop<ci;loop++) {
            long time = System.currentTimeMillis();

            Service.main(new String[]{"-n", "5000", "-f", "zhaohuang.sql"});
            all=all+(System.currentTimeMillis()-time)/1000.0/60.0;
            System.out.println("loop"+loop+":"+(System.currentTimeMillis()-time));

            getConn conn=new getConn();
            conn.Stmt().executeUpdate("truncate table zhzm_dbdf_test");
        }
        System.out.println("avg:"+all/ci+" min");
    }

    @Test
    public void typetest(){
        Service.main(new String[]{"-n", "5", "-f", "zhaohuang.sql","-i","sql"});
        Service.main(new String[]{"-n", "5", "-f", "zhaohuang.sql","-i","json"});
        Service.main(new String[]{"-n", "5", "-f", "zhaohuang.sql","-i","csv"});
//        Service.main(new String[]{"-n", "5", "-f", "zhaohuang.sql","-i","mongo"});
    }

}
