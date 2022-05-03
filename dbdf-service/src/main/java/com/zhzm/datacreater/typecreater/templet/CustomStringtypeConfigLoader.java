package com.zhzm.datacreater.typecreater.templet;

import com.zhzm.utils.BaseEnvironment;

import java.io.File;
import java.io.FileInputStream;
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

        File[] confiles;
//        Collections.addAll(confiles,getFiles(new File(regularpath)));
        String[] pathsa= BaseEnvironment.getEnvironment("CustomStringtypeConf").split(";");
        confiles=getFiles(pathsa);

        custom=new Properties();
        for(int i=0;i<confiles.length;i++){
            try {
                custom.load(new FileInputStream(confiles[i]));
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
