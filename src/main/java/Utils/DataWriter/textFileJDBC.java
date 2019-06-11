package Utils.DataWriter;

import Utils.DBConn.getConn;

import java.sql.SQLException;

public class textFileJDBC extends tF {
    private static textFileJDBC tf=new textFileJDBC();
    getConn conn=new getConn();

    @Override
    public synchronized boolean WriteLine(String insert) {
        try {
            conn.Stmt().execute(insert);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void closeWriter() throws SQLException {
        conn.Stmt().execute("commit;");
        conn.Stmt().close();
        conn.Conn().close();
    }

    public synchronized boolean WriteCreateinJDBC(String create) {
        try {
            conn.Stmt().executeUpdate(create);
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
