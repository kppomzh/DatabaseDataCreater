package dataStructure;

import Utils.privateRandom;

import java.math.BigInteger;

public class SelectUpdateBox {
    private String tableName,listName,updateList,range,updateString;

    public SelectUpdateBox(String tableName, String listName,ListStructure updateList){
        this.tableName = tableName;
        this.listName = listName;
        this.updateList = updateList.getListname();
        range=privateRandom.RandomBInteger(BigInteger.ZERO,new BigInteger("100000")).toString();
        updateString=updateList.getString();
    }

    public String getSelectSQL(){
        return "select * from "+tableName+" where "+listName+" < "+range;
    }

    public String getSelectRangeSQL(){
        return "select count(*) from "+tableName+" where "+listName+" < "+range;
    }

    public String getUpdateSQL(){
        return "update "+tableName+" set "+updateList+"="+updateString+" where "+listName+" < "+range;
    }
}
