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
    final static int ci = 10;

//    @Ignore
    @Test
    public void timetest() throws SQLException {
        double all = 0;
        for (int loop = 0; loop < ci; loop++) {
            long time = System.currentTimeMillis();

            Service.main(new String[]{"-n", "5000000", "-f", "zhaohuang.sql"});
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
//        Service.main(new String[]{"-version"});
        JarFile jar=new JarFile("D:\\Document\\OneDrive\\CodeRepo\\DatabaseDataCreater\\target\\DBDF-1.3.3.jar");

        //        for (Iterator<JarEntry> it = jar.entries().asIterator(); it.hasNext(); ) {
//            JarEntry je = it.next();
//            System.out.println(je.getRealName());
//            System.out.println(je.getAttributes().
//        }

//        System.out.println(jar.getEntry("version"));
        System.out.println(jar.getEntry("META-INF/maven/zhzm/DBDF/pom.properties"));
        ZipEntry je=jar.getEntry("META-INF/maven/zhzm/DBDF/pom.properties");
        InputStream is =jar.getInputStream(je);
        Properties pro=new Properties();
        pro.load(is);

        System.out.println(pro.get("version"));
    }
}
