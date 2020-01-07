package test;

import Utils.DBConn.getConn;
import main.Service;
import org.junit.Ignore;
import org.junit.Test;
import Utils.env_properties;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Properties;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;

//这里除了参数是手动写死的之外其他部分和正式的没有区别
public class alltest {
    final static int ci = 5;

    //    @Ignore
    @Test
    public void timetest() throws SQLException {
        double all = 0;
        for (int loop = 0; loop < ci; loop++) {
            long time = System.currentTimeMillis();

            Service.main(new String[]{"-n", "100000000", "-f", "zhaohuang.sql"});
            all = all + (System.currentTimeMillis() - time) / 1000.0 / 60.0;
            System.out.println("loop" + loop + ":" + (System.currentTimeMillis() - time));

            if (env_properties.getEnvironment("toDB").equals("jdbc")) {
                getConn conn = new getConn();
                conn.Stmt().executeUpdate("truncate table zhzm_dbdf_test");
            }
        }
        System.out.println("avg:" + all / ci + " min");
    }

    //    @Ignore
    @Test
    public void typetest() {
        Service.main(new String[]{"-n", "5", "-f", "zhaohuang.sql", "-i", "sql"});
        Service.main(new String[]{"-n", "5", "-f", "zhaohuang.sql", "-i", "json"});
        Service.main(new String[]{"-n", "5", "-f", "zhaohuang.sql", "-i", "csv"});
//        Service.main(new String[]{"-n", "5", "-f", "zhaohuang.sql","-i","mongo"});
    }

    @Test
    public void versiontest() throws SQLException, IOException {
        JarFile jar = new JarFile("D:\\Document\\OneDrive\\CodeRepo\\DatabaseDataCreater\\target\\DBDF-1.4.0.jar");

        System.out.println(jar.getEntry("META-INF/maven/zhzm/DBDF/pom.properties"));
        ZipEntry je = jar.getEntry("META-INF/maven/zhzm/DBDF/pom.properties");
        InputStream is = jar.getInputStream(je);
        Properties pro = new Properties();
        pro.load(is);

        System.out.println(pro.get("version"));
    }

    @Test
    public void helptest() {
        Service.main(new String[]{"-h"});
    }

    /**
     * 直接用命令行方式运行的模拟测试
     *
     * @param ar
     */
    public static void main(String... ar) {
        Service.main(new String[]{});
    }

    @Test
    public void insertnumtest() throws SQLException {
        double all = 0;
        int[] insertnum = {2500, 5000, 10000, 20000};
        for (int i = 0; i <4; i++) {
            for (int loop = 0; loop < ci; loop++) {
                long starttime = System.currentTimeMillis();
                Service.main(new String[]{"-n", "100000000", "-f", "zhaohuang.sql",
                        "--set","longerInsertNumber",String.valueOf(insertnum[i])});
                long stoptime=System.currentTimeMillis();
                all = all + (stoptime - starttime) / 1000.0 / 60.0;
                System.out.println("loop" + loop + ":" + (stoptime - starttime));

                if (env_properties.getEnvironment("toDB").equals("jdbc")) {
                    getConn conn = new getConn();
                    conn.Stmt().executeUpdate("truncate table zhzm_dbdf_test");
                }
            }
            System.out.println("avg:" + all / ci + " min");
            all = 0;
        }
    }
}
