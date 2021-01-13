package Utils.DBConn;

import SavingTypeString.DBJdbcLinkString;
import Utils.env_properties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class getConn {
    private Connection conn;
    private Statement stmt;

    public getConn() {
        try {
            conn = getConn();
            refreshStmt();
        } catch (Exception e) {
            e.printStackTrace();
            conn = null;
            stmt = null;
        }
    }

    public getConn(String soft,String IP,String port,String dbname,String user,String password) {
        try {
            conn = getConn(soft,IP, port, dbname, user, password);
            refreshStmt();
        } catch (Exception e) {
            e.printStackTrace();
            conn = null;
            stmt = null;
        }
    }

    private Connection getConn() throws Exception {
        return getConn(env_properties.getEnvironment("DBsoftware"),
                env_properties.getEnvironment("IP"),
                env_properties.getEnvironment("port",DBJdbcLinkString.getDefaultJDBCPort(env_properties.getEnvironment("DBsoftware"))),
                env_properties.getEnvironment("database"),
                env_properties.getEnvironment("user"),
                env_properties.getEnvironment("password"));
    }

    private Connection getConn(String soft,String IP,String port,String dbname,String user,String password) throws Exception {
        String url = DBJdbcLinkString.getJdbcLinkString(soft.toLowerCase());

        return DriverManager.getConnection(url.
                replace("{IP}", IP).
                replace("{port}", port).
                replace("{dbname}", dbname),
                user,
                password);
    }

    public Connection Conn() {
        return conn;
    }

    public Statement Stmt() {
        return stmt;
    }

    public void refreshStmt() {
        try {
            stmt = conn.createStatement();
//            if (env_properties.getEnvironment("DBsoftware").toLowerCase().equals("khan"))
//                stmt.executeUpdate("set dialect='oracle'");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
