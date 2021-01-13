package utils;

import Utils.DBConn.getConn;

import java.sql.ResultSet;
import java.sql.SQLException;

public class jdbcClient {
    private getConn conn;
    private String connMsg;

    public jdbcClient(String soft,String ip, String port, String dbname, String user, String pass) {
        this.conn = new getConn(soft,ip,port,dbname,user,pass);
        connMsg=ip+':'+port+'/'+dbname+';'+user;
    }

    public boolean runDDL(String SQL){
        boolean res=true;
        try {
            conn.Stmt().execute(SQL);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            res= false;
        }
        finally {
            return res;
        }
    }

    public long runSelect(String SQL){
        long res=System.nanoTime();
        try {
            ResultSet set=conn.Stmt().executeQuery(SQL);
            if(set==null)
                res=-1l;
            else
                res=System.nanoTime()-res;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            res=-1l;
        }
        finally {
            return res;
        }
    }

    public long runUpdate(String SQL){
        long res=System.nanoTime();
        try {
            conn.Stmt().executeLargeUpdate(SQL);
            res=System.nanoTime()-res;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            res=-1l;
        }
        finally {
            return res;
        }
    }

    public int getUpdateExplain(String SelectSQL){
        int res=-1;
        try {
            ResultSet set=conn.Stmt().executeQuery(SelectSQL);
            set.next();
            res=set.getInt(1);
        }
        finally {
            return res;
        }
    }

    public String getConnMsg() {
        return connMsg;
    }
}
