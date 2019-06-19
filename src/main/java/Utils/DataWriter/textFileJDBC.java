package Utils.DataWriter;

import Utils.DBConn.getConn;

import java.io.IOException;
import java.sql.Statement;

public class textFileJDBC extends tF {
    private getConn conn;
    private Statement stmt;

    public textFileJDBC(){
        conn=new getConn();
        stmt=conn.Stmt();
    }

    @Override
    public boolean WriteLine(String insert) {
        try {
            stmt.executeUpdate(insert);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void closeWriter() throws Exception {
        stmt.execute("commit;");
        stmt.close();
        conn.Conn().close();
    }
}
