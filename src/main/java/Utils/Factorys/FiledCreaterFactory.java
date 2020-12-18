package Utils.Factorys;

import DataCreater.FiledCreater.*;
import dataStructure.RuntimeEnvironment;
import dataStructure.TableStructure;

public class FiledCreaterFactory {
    public static baseFiledCreater getFiledCreater(TableStructure tableStructure, RuntimeEnvironment env){
        switch (env.getToDB()) {
            case "csv":
                return new csvFiledCreater(tableStructure,env);
            case "json":
                return new JsonFiledCreater(tableStructure,env);
            case "mongo":
                return new MongoFiledCreater(tableStructure,env);
            case "jdbc":
                if(env.getDBsoftware().equalsIgnoreCase("mongodb")){
                    return new MongoFiledCreater(tableStructure,env);
                }
            case "sql":
            default:
                return new SQLFiledCreater(tableStructure,env);
        }
    }
}
