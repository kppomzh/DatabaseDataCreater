package Utils.DataWriter;

import Utils.DBConn.getConn;
import dataStructure.RuntimeEnvironment;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;

public class textFileJDBC extends BaseWriter {
    private getConn conn;
    private Statement stmt;

    public textFileJDBC(RuntimeEnvironment env, TransferQueue<String> cache){
        super(env,cache);
        conn=new getConn(env);
        stmt=conn.Stmt();
    }

    @Override
    public void WriteLine() {
        try {
            String insert= writeCache.poll(5, TimeUnit.SECONDS);
            stmt.executeUpdate(insert.substring(0,insert.length()-1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() throws IOException {
        super.close();
        try {
            stmt.execute("commit;");
            stmt.close();
            conn.Conn().close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
