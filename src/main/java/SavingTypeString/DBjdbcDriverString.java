package SavingTypeString;

import java.util.HashMap;

public class DBjdbcDriverString {
    private static DBjdbcDriverString dBjdbcString = new DBjdbcDriverString();
    private static HashMap<String, String> DBjdbcDriverCorresponding;

    private DBjdbcDriverString() {
        DBjdbcDriverCorresponding = new HashMap<>();
        DBjdbcDriverCorresponding.put("oracle", "oracle.jdbc.driver.OracleDriver");
        DBjdbcDriverCorresponding.put("mysql", "com.mysql.jdbc.Driver");
        DBjdbcDriverCorresponding.put("sqlserver", "com.microsoft.jdbc.sqlserver.SQLServerDriver");
        DBjdbcDriverCorresponding.put("db2", "com.ibm.db2.jcc.DB2Driver");
        DBjdbcDriverCorresponding.put("mongodb", "mongodb.jdbc.MongoDriver");
        DBjdbcDriverCorresponding.put("postgresql", "org.postgresql.Driver");
        DBjdbcDriverCorresponding.put("sqlite", "org.sqlite.JDBC");
        DBjdbcDriverCorresponding.put("h2", "org.h2.Driver");
        DBjdbcDriverCorresponding.put("khan", "com.khandb.Driver");
        DBjdbcDriverCorresponding.put("presto","com.facebook.presto.jdbc.PrestoDriver");
//        DBjdbcDriverCorresponding.put("asl","");
//        DBjdbcDriverCorresponding.put("","");
    }

    public static String getJdbcDriverString(String DBname) {
        return dBjdbcString.DBjdbcDriverCorresponding.get(DBname.toLowerCase());
    }
}
