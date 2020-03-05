package Utils.Factorys;

import DataCreater.TypeCreater.*;
import DataCreater.TypeCreater.Advanced.AdvanceTypeCreater;
import DataCreater.TypeCreater.Advanced.PrimaryKey;
import Utils.env_properties;
import dataStructure.ListStructure;

public class TypeCreaterFactory {
    public static baseTypeCreater getTypeCreater(ListStructure list){
        if(list.isPrimary()){
            return new PrimaryKey();
        }

        switch(list.getListType()){
            case "int": case "decimal":
                return new numberTypeCreater(list.getRange()[0],list.getRange()[1],list.getNumberarea(),
                        Boolean.valueOf(env_properties.getEnvironment("canbeNegative")));
            case "date":
                return new dateTypeCreater();
            case "bool":
                return new boolTypeCreater();
            case "string":{
                if(list.isRegular()||list.isInline()||list.isPrimary()||list.isUnmake()){
                    return null;
                }
                else if(list.isAdvancedType()){
                    return new AdvanceTypeCreater(list.getAdvancedType(),list.getRange()[0]);
                }
            }
            default:
                return new stringTypeCreater(list.getRange()[0]);
        }
    }
}
