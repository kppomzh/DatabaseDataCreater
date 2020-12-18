package test;

import Utils.DBConn.getConn;
import Utils.Factorys.getEnvRecordFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class jdbctest {
    @Test
//    @Ignore
    public void conntodbtest() throws SQLException {
        getConn conn=new getConn(getEnvRecordFactory.getRuntimeEnv(new HashMap<>()));

        Statement stmt=conn.Stmt();
//        stmt.executeUpdate(insert);
        //ResultSet rs=
//        while(rs.next()){
//            ResultSetMetaData rsmd = rs.getMetaData();
//            System.out.println(rs.getString("User"));
//        }

        System.out.println(stmt.execute("create table zhzm_dbdf_test(\n" +
                "    CFG_ID varchar(100) primary key,\n" +
                "    telephone varchar(20),\n" +
                "    cardNumber varchar(20) ,\n" +
                "    FOUND_TIME int(12) ,\n" +
                "    found_time_partition numeric(9,1),\n" +
                "    RECV_TIME int(12),\n" +
                "    trans_proto varchar(255) ,\n" +
                "    addr_type int(1) ,\n" +
                "    d_ip char(16) ,\n" +
                "    d_port int(5) ,\n" +
                "    service int(2),\n" +
                "    entrance_id decimal(4,2),\n" +
                "    device_id int(2),\n" +
                "    direction numeric(1,1) /*dsf\n" +
                "    dsf*/,\n" +
                "    stream_dir int(1),\n" +
                "    cap_ip varchar(16) ,\n" +
                "    addr_list varchar(50) ,\n" +
                "    user_region varchar(40) ,\n" +
                "    Regulartest varchar(44),\n" +
                "    isinsert boolean,\n" +
                "    unmake_test VARCHAR(1) ,\n" +
                "    regdate date,\n" +
                "    checkdate timestamp \n" +
                ");"));
    }
}
