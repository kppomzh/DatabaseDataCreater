package test;

import Utils.DBConn.getConn;
import Utils.env_properties;
import main.Service;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;

//这里除了参数是手动写死的之外其他部分和正式的没有区别
public class alltest {
    final static int ci = 5;

    public void PerformanceBase(int createnum,int insertnum) throws SQLException {
        double all = 0;

        //虚拟机预热数据
        {
            Service.main(new String[]{"-n", "10000", "-f", "zhaohuang.sql"});
        }

        for (int loop = 0; loop < ci; loop++) {
            long time = System.currentTimeMillis();

            Service.main(new String[]{"-n", String.valueOf(createnum), "-f", "zhaohuang.sql","-a","-t","12","-L",
                    "--set","longerInsertNumber",String.valueOf(insertnum)});
            all = all + (System.currentTimeMillis() - time) / 1000.0 / 60.0;
            System.out.println("loop" + loop + ":" + (System.currentTimeMillis() - time));

            if (env_properties.getEnvironment("toDB").equals("jdbc")) {
                getConn conn = new getConn();
                conn.Stmt().executeUpdate("truncate table zhzm_dbdf_test");
            }
        }
        System.out.print("insertnum:");
        System.out.println(insertnum);
        System.out.println("avg:" + all / ci + " min");
    }

    @Test
    public void typetest() {
        Service.main(new String[]{"-n", "5", "-f", "zhaohuang.sql", "-i", "sql","--set","WriterEngine","screenout"});
        Service.main(new String[]{"-n", "5", "-f", "zhaohuang.sql", "-i", "json","--set","WriterEngine","screenout"});
        Service.main(new String[]{"-n", "5", "-f", "zhaohuang.sql", "-i", "csv","--set","WriterEngine","screenout"});
    }

    @Test
    public void versiontest() throws IOException {
        JarFile jar = new JarFile("target/DBDF-1.4.2.jar");

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
    public void FileWriteFullTimeTest() throws SQLException {
        int[] insertnum = {2500, 5000, 10000, 20000};
        for (int i = 0; i <insertnum.length; i++) {
            PerformanceBase(100000000,insertnum[i]);
        }
    }

    @Test
    public void JDBCWriteFullTimeTest() throws SQLException {
        env_properties.setEnvironment("toDB","jdbc");
        int[] insertnum = {10000};//2500, 5000, 10000,
        for (int i = 0; i <insertnum.length; i++) {
            PerformanceBase(10000000,insertnum[i]);
        }
    }
}
