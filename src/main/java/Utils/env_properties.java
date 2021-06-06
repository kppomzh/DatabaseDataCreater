package Utils;

import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import com.sun.management.OperatingSystemMXBean;

import java.io.*;
import java.lang.management.ManagementFactory;
import java.nio.charset.Charset;
import java.util.Properties;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;

public class env_properties {
    protected static final env_properties init = new env_properties();
    protected static Properties env;
    private OperatingSystemMXBean osmxb;

    private Charset envirmentCharset;

    protected env_properties(String str) {
    }

    private env_properties() {
        env = new Properties();
        FileInputStream FIS;
        InputStream pom;
        String path;
        osmxb = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        try {
            int cpunum=Runtime.getRuntime().availableProcessors();
            long memt=2*osmxb.getTotalPhysicalMemorySize()/950000000l;
            env.setProperty("basicThread",String.valueOf(Math.min(memt,cpunum)));

            String classresource=this.getClass().getResource(this.getClass().getSimpleName() + ".class").toString();
            if (classresource.startsWith("file:")) {
                MavenXpp3Reader reader = new MavenXpp3Reader();
                String myPom = System.getProperty("user.dir") + File.separator + "pom.xml";
                try {
                    Model model = reader.read(new FileReader(myPom));
                    env.put("version", model.getVersion());
                } catch (Exception e) {

                }

                FIS = new FileInputStream(new File("config.properties"));
                env.load(FIS);
            } else if (classresource.startsWith("jar:")) {
                path = System.getProperty("java.class.path");
                int firstIndex = path.lastIndexOf(System.getProperty("path.separator")) + 1;
                int lastIndex = path.lastIndexOf(File.separator) + 1;

                String jarPath=path.substring(firstIndex);

                path = jarPath.substring(0, lastIndex) + "config.properties";
                FIS = new FileInputStream(path);
                env.load(FIS);
                try {
                    JarFile jar=new JarFile(jarPath);
                    ZipEntry je=jar.getEntry("META-INF/maven/zhzm/DBDF/pom.properties");
                    pom =jar.getInputStream(je);
                    env.load(pom);
                    pom.close();
                } catch (IOException e) {
                    env.put("version","");
                }
            } else {
                throw new IOException();
            }
            FIS.close();
        } catch (FileNotFoundException ex) {
            System.out.println("环境配置文件不存在！");
        } catch (IOException ex) {
            System.out.println("环境配置文件无法读取！");
        } finally //可以通过finally加载默认参数，防止程序崩溃
        {
            loadDefaultProp();
        }
    }

    private void loadDefaultProp() {
        if(!env.containsKey("dbCharSet")||env.getProperty("dbCharSet").equals("")){
            envirmentCharset=Charset.forName((String) System.getProperties().get("file.encoding"));
        }
        else{
            envirmentCharset=Charset.forName(env.getProperty("dbCharSet"));
        }
        if (!env.containsKey("toDB")) {
            env.setProperty("toDB", "sql");
        }
        if (!env.containsKey("baseFileDir")) {
            env.setProperty("baseFileDir", ".\\");
        }
        if (!env.containsKey("Optimal")) {
            env.setProperty("Optimal", "false");
        }
        if (!env.containsKey("TOTAL_THREADS")) {
            env.setProperty("TOTAL_THREADS", "1");
        }
        if (!env.containsKey("defaultProportion")) {
            env.setProperty("defaultProportion", "0.5");
        }
        if (!env.containsKey("canbeNegative")) {
            env.setProperty("canbeNegative", "false");
        }
        if (!env.containsKey("WriterEngine")) {
            env.setProperty("WriterEngine", "default");
        }
        if (!env.containsKey("longerInsert")) {
            env.setProperty("longerInsert", "false");
        }
//        System.out.println("默认参数已加载。");
    }

    public static String getEnvironment(String envstring) {
        return getEnvironment(envstring,"");
    }

    public static String getEnvironment(String envstring,String defaultStr) {
        String res=env.getProperty(envstring);
        if (res==null||res.equals("")){
            return defaultStr;
        }
        return res.strip();
    }

    public static void setEnvironment(String envName, String envstring) {
        env.setProperty(envName, envstring);
    }

    public static Properties getJDBCEnv() {
        return env;
    }

    public static Charset getEnvirmentCharset() {
        return init.envirmentCharset;
    }
}
