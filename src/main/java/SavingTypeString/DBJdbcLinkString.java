package SavingTypeString;

import java.util.HashMap;

public class DBJdbcLinkString {
    private static DBJdbcLinkString dBjdbcString = new DBJdbcLinkString();
    private static HashMap<String, String> DBjdbcLinkCorresponding;

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
//        DBjdbcLinkCorresponding.put("asl","");
//        DBjdbcDriverCorresponding.put("","");
    }

    public static String getJdbcLinkString(String DBname) {
        return dBjdbcString.DBjdbcLinkCorresponding.get(DBname.toLowerCase());
    }
}
