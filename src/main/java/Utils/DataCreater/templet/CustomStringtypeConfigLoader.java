package Utils.DataCreater.templet;

import Utils.env_properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Properties;

/**
 * 加载自定义的Stringtype模式
 */
public class CustomStringtypeConfigLoader{
    private static CustomStringtypeConfigLoader cscl=new CustomStringtypeConfigLoader();
    private Properties custom;
    private String regularsonpath="regular";

    private CustomStringtypeConfigLoader(){
        String regularpath = "";

        LinkedList<File> confiles=new LinkedList<>();
//        Collections.addAll(confiles,getFiles(new File(regularpath)));
        String[] pathsa= env_properties.getEnvironment("CustomStringtypeConf").split(";");
        Collections.addAll(confiles,getFiles(pathsa));

        custom=new Properties();
        for(File f:confiles){
            try {
                custom.load(new FileInputStream(f));
            } catch (Exception e) {
                continue;
            }
        }
    }
    public static Properties getCustomStringtypes(){
        return cscl.custom;
    }

    private File[] getFiles(File dir){
        if(dir.exists())
            return dir.listFiles();
        return new File[0];
    }
    private File[] getFiles(String[] pathsa){
        File[] files=new File[pathsa.length];
        for(int loop=0;loop<pathsa.length;loop++){
            files[loop]=new File(pathsa[loop]);
        }
        return files;
    }
}
