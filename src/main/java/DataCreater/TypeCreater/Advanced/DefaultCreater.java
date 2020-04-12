package DataCreater.TypeCreater.Advanced;

import DataCreater.TypeCreater.baseTypeCreater;
import DataCreater.TypeCreater.stringTypeCreater;
import Utils.StringSpecificationOutput;
import Utils.env_properties;
import Utils.privateRandom;
import dataStructure.ListStructure;

public class DefaultCreater implements baseTypeCreater {
    private String DefaultStr;
    private baseTypeCreater innerCreater;
    private double Proportion;

    public DefaultCreater(baseTypeCreater creater, ListStructure list, double Proportion){
        innerCreater=creater;
        this.Proportion=Proportion;

        if("sql".equals(env_properties.getEnvironment("toDB")) && list.getListType().equals("date")){
            DefaultStr=StringSpecificationOutput.specDate(list.getDefaultStr());
        }
        else if(list.getListType().equals("string")){
            DefaultStr='\''+StringSpecificationOutput.specString(list.getDefaultStr(),list.getRange()[0])+'\'';
        }
        else if(list.getListType().equals("number")) {
            this.DefaultStr=StringSpecificationOutput.specNumber(list.getDefaultStr(),list.getRange()[0],list.getRange()[1]);
        }
        else if(list.getListType().equals("bool")) {
            this.DefaultStr=StringSpecificationOutput.specBool(list.getDefaultStr());
        }
    }

    @Override
    public String getString(Object... option) {
        return privateRandom.RandomDouble(0,1)<Proportion?DefaultStr:innerCreater.getString();
    }
}
