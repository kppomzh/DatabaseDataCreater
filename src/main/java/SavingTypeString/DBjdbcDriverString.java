package SavingTypeString;

import java.sql.Driver;
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
//        DBjdbcDriverCorresponding.put("hive","org.apache.hive.jdbc.HiveDriver");
//        DBjdbcDriverCorresponding.put("asl","");
//        DBjdbcDriverCorresponding.put("","");
    }

    public static String getJdbcDriverString(String DBname) {
        return dBjdbcString.DBjdbcDriverCorresponding.get(DBname.toLowerCase());
    }

    public static Driver getJdbcDriver(String DBname) throws Exception{
        switch(DBname.toLowerCase()){
            case "oracle":
                return new oracle.jdbc.driver.OracleDriver();
            case "mysql":
                return new com.mysql.cj.jdbc.Driver();
            case "sqlserver":
                return new com.microsoft.sqlserver.jdbc.SQLServerDriver();
            case "db2":
                return new com.ibm.db2.jcc.DB2Driver();
//            case "mongodb":
//                return new com.mongodb.reactivestreams.client.gridfs.helpers.AsyncStreamHelper.toAsyncInputStream();
            case "postgresql":
                return new org.postgresql.Driver();
            case "sqlite":
                return new org.sqlite.JDBC();
            case "h2":
                return new org.h2.Driver();
            case "presto":
                return new com.facebook.presto.jdbc.PrestoDriver();
//            case "hive":
//                return new org.apache.hive.jdbc.HiveDriver();
            default:
                throw new ClassNotFoundException(DBname);
        }
    }
}
