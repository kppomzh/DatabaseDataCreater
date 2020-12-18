package Utils;

import Utils.Record.RuntimeEnvironment;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Properties;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;

public class BaseProperties {
    protected static final BaseProperties init = new BaseProperties();
    protected static Properties env;

    private Charset envirmentCharset;

    private BaseProperties() {
        env = new Properties();
        FileInputStream FIS;
        InputStream pom;
        String path;
        try {
            env.setProperty("nCPU", String.valueOf(Runtime.getRuntime().availableProcessors()));

            String classresource=this.getClass().getResource(this.getClass().getSimpleName() + ".class").toString();
            if (classresource.startsWith("file:")) {
                MavenXpp3Reader reader = new MavenXpp3Reader();
                String myPom = System.getProperty("user.dir") + File.separator + "pom.xml";
                try {
                    Model model = reader.read(new FileReader(myPom));
                    env.put("version", model.getVersion());
                } catch (Exception e) {

                }

                FIS = new FileInputStream(new File("client.properties"));
                env.load(FIS);
            } else if (classresource.startsWith("jar:")) {
                path = System.getProperty("java.class.path");
                int firstIndex = path.lastIndexOf(System.getProperty("path.separator")) + 1;
                int lastIndex = path.lastIndexOf(File.separator) + 1;

                String jarPath=path.substring(firstIndex);

                path = jarPath.substring(0, lastIndex) + "client.properties";
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

//        System.out.println("默认参数已加载。");
    }

    public static String getEnvironment(String envstring) {
        return env.getProperty(envstring).strip();
    }

    public static void setEnvironment(String envName, String envstring) {
        env.setProperty(envName, envstring);
    }

    public static RuntimeEnvironment getEnvironment() {
        return new RuntimeEnvironment(
                getEnvironment("ServerHost"),
                Integer.valueOf(getEnvironment("ServerPort"))
        );
    }
}
