package SavingTypeString;

import java.util.HashMap;
import java.util.Set;

public class DataType {
    private static DataType dt = new DataType();
    private HashMap<String, String> type2typeCorresponding;

    private DataType() {
        type2typeCorresponding = new HashMap<>();
        type2typeCorresponding.put("integer", "int");
        type2typeCorresponding.put("int", "int");

        type2typeCorresponding.put("number", "decimal");
        type2typeCorresponding.put("numeric", "decimal");
        type2typeCorresponding.put("float", "decimal");
        type2typeCorresponding.put("double", "decimal");
        type2typeCorresponding.put("decimal", "decimal");

        type2typeCorresponding.put("varchar", "string");
        type2typeCorresponding.put("varchar2", "string");
        type2typeCorresponding.put("char", "string");
        type2typeCorresponding.put("nvarchar", "string");
        type2typeCorresponding.put("nvarchar2", "string");
        type2typeCorresponding.put("string", "string");
        type2typeCorresponding.put("text", "string");

        type2typeCorresponding.put("date", "date");
        type2typeCorresponding.put("timestamp", "date");

        type2typeCorresponding.put("boolean", "bool");
        type2typeCorresponding.put("bool", "bool");
    }

    public static String getDataTypeString(String sourceType) {
        return dt.type2typeCorresponding.get(sourceType);
    }

    public static Set<String> getTypeKeySet() {
        return dt.type2typeCorresponding.keySet();
    }
}
