package com.zhzm.datacreater.factory;

import com.zhzm.datacreater.line.*;
import com.zhzm.datacreater.table.TableMaker;
import com.zhzm.utils.BaseEnvironment;

public class FiledCreaterFactory {
    public static BaseFiledCreater getFiledCreater(TableMaker maker){
        switch (BaseEnvironment.getEnvironment("toDB")) {
            case "csv":
                return new CsvFiledCreater(maker);
            case "json":
                return new JsonFiledCreater(maker);
            case "mongo":
                return new MongoFiledCreater(maker);
            case "jdbc":
                if(BaseEnvironment.getEnvironment("DBsoftware").toLowerCase().equals("mongodb")){
                    return new MongoFiledCreater(maker);
                }
            case "sql":
            default:
                return new SQLFiledCreater(maker);
        }
    }
}
