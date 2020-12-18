package Utils.DBConn;

import SavingTypeString.DBJdbcLinkString;
import dataStructure.RuntimeEnvironment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class getConn {
    private Connection conn;
    private Statement stmt;

    public getConn(RuntimeEnvironment env) {
        try {
            conn = getConn(env);
            refreshStmt();
        } catch (Exception e) {
            e.printStackTrace();
            conn = null;
            stmt = null;
        }
    }

    private Connection getConn(RuntimeEnvironment env) throws Exception {
        String url = DBJdbcLinkString.getJdbcLinkString(env.getDBsoftware().toLowerCase());
        String port = env.getPort().equals("") ? DBJdbcLinkString.getDefaultJDBCPort(env.getDBsoftware()) : env.getPort();

        return DriverManager.getConnection(url.
                replace("{IP}", env.getIP()).
                replace("{port}", port).
                replace("{dbname}", env.getDatabase()), env.getUser(), env.getPassword());
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
