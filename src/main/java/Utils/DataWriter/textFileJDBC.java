package Utils.DataWriter;

import Utils.DBConn.getConn;
import dataStructure.RuntimeEnvironment;

import java.sql.Statement;

public class textFileJDBC extends BaseWriter {
    private getConn conn;
    private Statement stmt;

    public textFileJDBC(RuntimeEnvironment env){
        super(env);
        conn=new getConn(env);
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
