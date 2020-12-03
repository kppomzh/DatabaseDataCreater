package Utils.Factorys;

import Utils.env_properties;
import dataStructure.RuntimeEnvironment;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class getEnvRecordFactory {
    public static RuntimeEnvironment getRuntimeEnv(Map<String,String> template) {
        Map<String,String> allConf=new HashMap<>();
        Properties config= env_properties.getJDBCEnv();
        for(String key:config.stringPropertyNames()){
            allConf.put(key,config.getProperty(key));
        }
        allConf.putAll(template);

        RuntimeEnvironment res = new RuntimeEnvironment(
                Double.valueOf(allConf.getOrDefault("createNum","0")),
                allConf.get("SQLString"),
                allConf.get("DBsoftware"),
                allConf.get("IP"),
                allConf.get("port"),
                allConf.get("user"),
                allConf.get("password"),
                allConf.get("database"),
                allConf.get("toDB"),
                allConf.get("baseFileDir"),
                allConf.get("WriterEngine"),
                Integer.valueOf(allConf.getOrDefault("totalThreads","1")),
                Integer.valueOf(allConf.get("longerInsertNumber")),
                Double.valueOf(allConf.get("defaultProportion")),
                allConf.get("optimal").equals("true"),
                allConf.get("canbeNegative").equals("true"),
                allConf.get("longerInsert").equals("true"),
                Charset.forName(allConf.get("dbCharSet"))
        );
        return res;
    }
}
