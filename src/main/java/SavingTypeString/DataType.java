package SavingTypeString;

import java.util.HashMap;

public class DataType {
    private static DataType dt=new DataType();
    private HashMap<String,String> type2typeCorresponding;
    private DataType()
    {
        type2typeCorresponding=new HashMap<>();
        type2typeCorresponding.put("number","number");
        type2typeCorresponding.put("numeric","number");
        type2typeCorresponding.put("int","number");
        type2typeCorresponding.put("decimal","number");

        type2typeCorresponding.put("varchar","string");
        type2typeCorresponding.put("varchar2","string");
        type2typeCorresponding.put("char","string");
        type2typeCorresponding.put("nvarchar","string");

        type2typeCorresponding.put("date","date");
        type2typeCorresponding.put("timestamp","date");

    }

    public static String getDataTypeString(String sourceType){
        return dt.type2typeCorresponding.get(sourceType);
    }
}
