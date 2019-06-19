package SavingTypeString;

import java.util.HashMap;

public class DBJdbcLinkString {
    private static DBJdbcLinkString dBjdbcString = new DBJdbcLinkString();
    private static HashMap<String, String> DBjdbcLinkCorresponding;
    private static HashMap<String, String> DBjdbcDefaultPort;

    private DBJdbcLinkString() {
        DBjdbcLinkCorresponding = new HashMap<>();
        DBjdbcLinkCorresponding.put("oracle", "jdbc:oracle:thin:@{IP}:{port}:{dbname}");
        DBjdbcLinkCorresponding.put("mysql", "jdbc:mysql://{IP}:{port}/{dbname}");
        DBjdbcLinkCorresponding.put("sqlserver", "jdbc:microsoft:sqlserver://{IP}:{port};DatabaseName={dbname}");
        DBjdbcLinkCorresponding.put("db2", "jdbc:db2://{IP}:{port}/{dbname}");
        DBjdbcLinkCorresponding.put("mongodb", "mongodb://{IP}:{port}/{dbname}");
        DBjdbcLinkCorresponding.put("postgresql", "jdbc:postgresql://{IP}:{port}/{dbname}");
        DBjdbcLinkCorresponding.put("sqlite", "jdbc:sqlite:{dbname}");
        DBjdbcLinkCorresponding.put("h2", "jdbc:h2:tcp://{IP}:{port}/{dbname}");
        DBjdbcLinkCorresponding.put("khan", "jdbc:khandb://{IP}:{port}/{dbname}");
        DBjdbcLinkCorresponding.put("presto", "jdbc:presto://{IP}:{port}/{dbname}/default");
        DBjdbcLinkCorresponding.put("hive", "jdbc:hive2://{IP}:{port}/{dbname}");
//        DBjdbcLinkCorresponding.put("asl","");
//        DBjdbcDriverCorresponding.put("","");

        DBjdbcDefaultPort=new HashMap<>();
        DBjdbcDefaultPort.put("oracle","1521");
        DBjdbcDefaultPort.put("mysql","3306");
        DBjdbcDefaultPort.put("postgresql","5432");
        DBjdbcDefaultPort.put("sqlserver","1433");
        DBjdbcDefaultPort.put("db2","5000");
        DBjdbcDefaultPort.put("mongodb","27017");
        DBjdbcDefaultPort.put("h2","9092");
        DBjdbcDefaultPort.put("sqlite",null);
        DBjdbcDefaultPort.put("presto","8080");
        DBjdbcDefaultPort.put("hive","21050");
    }

    public static String getJdbcLinkString(String DBname) {
        return dBjdbcString.DBjdbcLinkCorresponding.get(DBname.toLowerCase());
    }

    public static String getDefaultJDBCPort(String DBname){
        return dBjdbcString.DBjdbcDefaultPort.get(DBname.toLowerCase());
    }
}
