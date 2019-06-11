package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class env_properties {
    protected static final env_properties init = new env_properties();
    protected static Properties env;

    protected env_properties(String str) {
    }

    private env_properties() {
        boolean load = false;
        env = new Properties();
        FileInputStream FIS;
        String path = null;
        try {
            env.setProperty("nCPU", String.valueOf(Runtime.getRuntime().availableProcessors()));

            if (this.getClass().getResource(this.getClass().getSimpleName() + ".class")
                    .toString().startsWith("file:")) {
                FIS = new FileInputStream(new File("config.properties"));
                env.load(FIS);
            } else if (this.getClass().getResource(this.getClass().getSimpleName() + ".class")
                    .toString().startsWith("jar:")) {
                path = System.getProperty("java.class.path");
                int firstIndex = path.lastIndexOf(System.getProperty("path.separator")) + 1;
                int lastIndex = path.lastIndexOf(File.separator) + 1;
                path = path.substring(firstIndex, lastIndex) + "config.properties";
                FIS = new FileInputStream(path);
                env.load(FIS);
            } else {
                throw new IOException();
            }
            FIS.close();
        } catch (FileNotFoundException ex) {
            System.out.println("环境配置文件不存在！");
            System.out.println(path);
            load = true;
        } catch (IOException ex) {
            System.out.println("环境配置文件无法读取！");
            load = true;
        } finally //可以通过finally加载默认参数，防止程序崩溃
        {
            loadDefaultProp();
        }
    }

    private void loadDefaultProp() {
        if (!env.containsKey("toDB")) {
            env.setProperty("toDB", "sql");
        }
        if (!env.containsKey("baseFileDir")) {
            env.setProperty("baseFileDir", ".\\");
        }
        if (!env.containsKey("Optimal")) {
            env.setProperty("Optimal", "false");
        }
        if (!env.containsKey("asynchronous")) {
            env.setProperty("asynchronous", "false");
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
        return init.env.getProperty(envstring);//.strip();
    }

    public static void setEnvironment(String envName, String envstring) {
        init.env.setProperty(envName, envstring);
    }
}
