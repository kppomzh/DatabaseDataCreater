package com.zhzm.datacreater.factory;

import com.zhzm.datacreater.line.*;
import com.zhzm.datacreater.table.TableMaker;
import com.zhzm.datastructure.table.TableStructure;
import com.zhzm.utils.BaseEnvironment;

public class FiledCreaterFactory {
    public static baseFiledCreater getFiledCreater(TableMaker maker){
        switch (BaseEnvironment.getEnvironment("toDB")) {
            case "csv":
                return new csvFiledCreater(maker);
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
