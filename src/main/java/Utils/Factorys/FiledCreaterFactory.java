package Utils.Factorys;

import DataCreater.FiledCreater.*;
import Utils.baseEnvironment;
import dataStructure.TableStructure;

public class FiledCreaterFactory {
    public static baseFiledCreater getFiledCreater(TableStructure tableStructure){
        switch (baseEnvironment.getEnvironment("toDB")) {
            case "csv":
                return new csvFiledCreater(tableStructure);
            case "json":
                return new JsonFiledCreater(tableStructure);
            case "mongo":
                return new MongoFiledCreater(tableStructure);
            case "jdbc":
                if(baseEnvironment.getEnvironment("DBsoftware").toLowerCase().equals("mongodb")){
                    return new MongoFiledCreater(tableStructure);
                }
            case "sql":
            default:
                return new SQLFiledCreater(tableStructure);
        }
    }
}
