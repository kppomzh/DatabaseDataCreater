package Utils.dbconn;

import SavingTypeString.DBJdbcLinkString;
import SavingTypeString.DBjdbcDriverString;
import Utils.env_properties;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class getConn {
    private static final getConn getConn=new getConn();
    private static Connection conn;
    private static Statement stmt;
    private getConn()  {
        try {
            conn=getConn();
            refreshStmt();
        } catch (Exception e) {
            e.printStackTrace();
            conn=null;
            stmt=null;
        }
    }

    private static Connection getConn() throws Exception {
        Class.forName(DBjdbcDriverString.getJdbcDriverString(env_properties.getEnvironment("DBsoftware")));
        String url=DBJdbcLinkString.getJdbcLinkString(env_properties.getEnvironment("DBsoftware"));
        return DriverManager.getConnection(url.
                    replace("{IP}",env_properties.getEnvironment("IP")).
                    replace("{port}",env_properties.getEnvironment("port")).
                    replace("{dbname}",env_properties.getEnvironment("database")),
                env_properties.getEnvironment("user"),
                env_properties.getEnvironment("password"));
    }

    public static Connection Conn()
    {return getConn.conn;}
    public static Statement Stmt()
    {return getConn.stmt;}
    public static void refreshStmt()
    {
        try {
            getConn.stmt=getConn.conn.createStatement();
            if(env_properties.getEnvironment("DBsoftware").equals("khan"))
                getConn.stmt.executeUpdate("set dialect='oracle'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
