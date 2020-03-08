package DataCreater.TypeCreater.Advanced;

import DataCreater.TypeCreater.baseTypeCreater;
import DataCreater.TypeCreater.stringTypeCreater;
import Utils.privateRandom;

public class DefaultCreater implements baseTypeCreater {
    private String DefaultStr;
    private baseTypeCreater innerCreater;
    private double Proportion;

    public DefaultCreater(baseTypeCreater creater,String defaultStr,double Proportion){
        innerCreater=creater;
        this.DefaultStr=defaultStr;
        this.Proportion=Proportion;
    }

    @Override
    public String getString(Object... option) {
        return privateRandom.RandomDouble(0,1)<Proportion?DefaultStr:innerCreater.getString();
    }
}
