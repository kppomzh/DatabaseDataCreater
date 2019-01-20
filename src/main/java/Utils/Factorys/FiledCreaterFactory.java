package Utils.Factorys;

import Utils.DataCreater.FiledCreater.*;
import Utils.env_properties;
import dataStructure.TableStructure;

public class FiledCreaterFactory {
    public static baseCreater getFiledCreater(TableStructure tableStructure){
        switch (env_properties.getEnvironment("toDB")) {
            case "csv":
                return new csvCreater(tableStructure);
            case "json":
                return new JsonCreater(tableStructure);
            case "mongo":
                return new MongoCreater(tableStructure);
            case "jdbc":
                if(env_properties.getEnvironment("DBsoftware").toLowerCase().equals("mongodb")){
                    return new MongoCreater(tableStructure);
                }
            case "sql":
            default:
                return new SQLCreater(tableStructure);
        }
    }
}
