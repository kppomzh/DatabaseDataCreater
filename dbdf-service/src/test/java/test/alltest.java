package test;

import com.zhzm.service.LocalServer;
import com.zhzm.utils.BaseEnvironment;
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
    final static String testfile="qiu.sql";

    @Test
    public void typetest() throws IOException {
//        Service.main(new String[]{"-n", "5", "-f", "zhaohuang.sql", "-i", "mongo","--set","WriterEngine","screenout"});
//        Service.main(new String[]{"-n", "5", "-f", "zhaohuang.sql", "-i", "sql","--set","WriterEngine","screenout"});
//        Service.main(new String[]{"-n", "5", "-f", "zhaohuang.sql", "-i", "json","--set","WriterEngine","screenout"});
//        Service.main(new String[]{"-n", "5", "-f", "zhaohuang.sql", "-i", "csv","--set","WriterEngine","screenout"});
        LocalServer.main(new String[]{"-n", "5", "-f", "../rely.sql", "-i", "csv","--set","WriterEngine","screenout"});
    }

    @Test
    public void versiontest() throws IOException {
        JarFile jar = new JarFile("D:\\Document\\OneDrive\\CodeRepo\\DatabaseDataCreater\\target\\DBDF-1.4.0.jar");

        System.out.println(jar.getEntry("META-INF/maven/zhzm/DBDF/pom.properties"));
        ZipEntry je = jar.getEntry("META-INF/maven/zhzm/DBDF/pom.properties");
        InputStream is = jar.getInputStream(je);
        Properties pro = new Properties();
        pro.load(is);

        System.out.println(pro.get("version"));
    }

    @Test
    public void helptest() throws IOException {
        LocalServer.main(new String[]{"-h"});
    }

    /**
     * 直接用命令行方式运行的模拟测试
     *
     * @param ar
     */
    public static void main(String... ar) throws IOException {
        LocalServer.main(new String[]{"-n", "10000", "-f", testfile});
    }

    @Test
    public void FileWriteFullTimeTest() throws SQLException, IOException {
        int[] insertnum = {10000};
        for (int value : insertnum) {
            testFunc.setLocalEnv(value);
            testFunc.PerformanceBase(ci, 2100000000);
        }
    }

//    @Ignore
    @Test
    public void JDBCWriteFullTimeTest() throws SQLException, IOException {
        BaseEnvironment.setEnvironment("toDB","jdbc");
        int[] insertnum = {10000};//2500, 5000, 10000,
        for (int value : insertnum) {
            testFunc.PerformanceBase(ci, 10000000);
        }
    }

    @Test
    public void MultiThreadOneFileTest() throws SQLException, IOException {
        BaseEnvironment.setEnvironment("TOTAL_THREADS","3");
        testFunc.PerformanceBase(1,15000);
    }

}
