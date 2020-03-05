package Utils.Factorys;

import DataCreater.FiledCreater.*;
import Utils.env_properties;
import dataStructure.TableStructure;

public class FiledCreaterFactory {
    public static baseFiledCreater getFiledCreater(TableStructure tableStructure){
        switch (env_properties.getEnvironment("toDB")) {
            case "csv":
                return new csvFiledCreater(tableStructure);
            case "json":
                return new JsonFiledCreater(tableStructure);
            case "mongo":
                return new MongoFiledCreater(tableStructure);
            case "jdbc":
                if(env_properties.getEnvironment("DBsoftware").toLowerCase().equals("mongodb")){
                    return new MongoFiledCreater(tableStructure);
                }
            case "sql":
            default:
                return new SQLFiledCreater(tableStructure);
        }
    }
}
