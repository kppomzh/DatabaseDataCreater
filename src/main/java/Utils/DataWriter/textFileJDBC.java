package Utils.DataWriter;

import Utils.dbconn.getConn;

import java.sql.SQLException;

public class textFileJDBC extends tF {
    private static textFileJDBC tf=new textFileJDBC();

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

    public static textFileJDBC getInstance() {
        return tf;
    }
}
