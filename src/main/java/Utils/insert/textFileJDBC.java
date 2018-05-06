package Utils.insert;

import Utils.dbconn.getConn;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;

public class textFileJDBC implements tF {
    @Override
    public synchronized boolean WriteLine(String insert) {
        try {
            getConn.Stmt().execute(insert);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public synchronized boolean WriteCreateinJDBC(String create) {
        try {
            getConn.Stmt().executeUpdate(create);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
