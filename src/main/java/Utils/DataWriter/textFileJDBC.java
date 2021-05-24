package Utils.DataWriter;

import Utils.DBConn.getConn;

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
            stmt.executeUpdate(insert.substring(0,insert.length()-1));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void close() throws Exception {
        stmt.execute("commit;");
        stmt.close();
        conn.Conn().close();
    }
}
