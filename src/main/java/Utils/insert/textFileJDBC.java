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

    @Override
    public void closeWriter() throws SQLException {
        getConn.Stmt().execute("commit;");
        getConn.Stmt().close();
        getConn.Conn().close();
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
