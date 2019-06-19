package test;

import SavingTypeString.DBJdbcLinkString;
import SavingTypeString.DBjdbcDriverString;
import Utils.DBConn.getConn;
import Utils.env_properties;
import org.junit.Test;

import java.sql.*;

public class jdbctest {
    @Test
    public void conntodbtest(String insert) throws SQLException {
        getConn conn=new getConn();

        Statement stmt=conn.Stmt();
        stmt.executeUpdate(insert);
        //ResultSet rs=
//        while(rs.next()){
//            ResultSetMetaData rsmd = rs.getMetaData();
//            System.out.println(rs.getString("User"));
//        }

        System.out.println(stmt.execute("create table zhzm_dbdf_test(\n" +
                "    CFG_ID numeric(12),\n" +
                "    FOUND_TIME numeric(12),\n" +
                "    found_time_partition numeric(9),\n" +
                "    RECV_TIME numeric(10),\n" +
                "    trans_proto varchar(40),\n" +
                "    addr_type numeric(1),\n" +
                "    d_ip varchar(16),\n" +
                "    s_ip varchar(16),\n" +
                "    d_port varchar(5),\n" +
                "    s_port varchar(4),\n" +
                "    service numeric(2),\n" +
                "    entrance_id numeric(2),\n" +
                "    device_id numeric(2),\n" +
                "    direction numeric(1),\n" +
                "    stream_dir numeric(1),\n" +
                "    cap_ip varchar(16),\n" +
                "    addr_list varchar(50),\n" +
                "    user_region varchar(40),\n" +
                "    Regulartest varchar(44),\n" +
                "    isinsert boolean \n" +
                ");"));
    }
}
