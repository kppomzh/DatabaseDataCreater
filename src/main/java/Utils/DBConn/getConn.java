package Utils.DBConn;

import SavingTypeString.DBJdbcLinkString;
import SavingTypeString.DBjdbcDriverString;
import Utils.env_properties;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.Statement;

public class getConn {
    private Connection conn;
    private Statement stmt;
    public getConn()  {
        try {
            conn=getConn();
            refreshStmt();
        } catch (Exception e) {
            e.printStackTrace();
            conn=null;
            stmt=null;
        }
    }

    private Connection getConn() throws Exception {
        System.setProperty("jdbc.driver",
                DBjdbcDriverString.getJdbcDriverString(env_properties.getEnvironment("DBsoftware").toLowerCase()));
        String url=DBJdbcLinkString.getJdbcLinkString(env_properties.getEnvironment("DBsoftware").toLowerCase());

        Driver driver=DBjdbcDriverString.getJdbcDriver(env_properties.getEnvironment("DBsoftware").toLowerCase());
        return driver.connect(url.
                replace("{IP}",env_properties.getEnvironment("IP")).
                replace("{port}",env_properties.getEnvironment("port")).
                replace("{dbname}",env_properties.getEnvironment("database")),
                env_properties.getJDBCEnv());
    }

    public Connection Conn()
    {return conn;}
    public Statement Stmt()
    {return stmt;}
    public void refreshStmt()
    {
        try {
            stmt=conn.createStatement();
            if(env_properties.getEnvironment("DBsoftware").toLowerCase().equals("khan"))
                stmt.executeUpdate("set dialect='oracle'");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
