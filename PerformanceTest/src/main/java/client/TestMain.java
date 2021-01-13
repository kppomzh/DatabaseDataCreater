package client;

import CreateSQLParser.TableStructure.CreateTableStructure;
import DataCreater.FiledCreater.SQLFiledCreater;
import DataCreater.FiledCreater.baseFiledCreater;
import Utils.FileLoader;
import dataStructure.SelectUpdateBox;
import dataStructure.TableStructure;
import utils.BaseProperties;
import utils.DastabaseMessage;
import utils.MakeSQLBox;
import utils.jdbcClient;

import java.io.File;
import java.io.IOException;

public class TestMain {
    //    private String[] createSQLs;
    private String createSQLs;
    private Integer insertNumber;
    private TableStructure ts;
    private baseFiledCreater creater;
    private boolean init, vacuum;
    private int insert, select, update;
    private jdbcClient[] dm;

    public TestMain(String filename, Integer insertNumber) throws Exception {
        this.createSQLs = FileLoader.loadFile(new File(filename));
        this.insertNumber = insertNumber;
        ts = CreateTableStructure.makeStructure(createSQLs);
        creater = new SQLFiledCreater(ts);

        String[] hosts = BaseProperties.getEnvironment("hosts").split(","),
                ports = BaseProperties.getEnvironment("ports").split(","),
                users = BaseProperties.getEnvironment("usernames").split(","),
                passes = BaseProperties.getEnvironment("passwords").split(","),
                dbnames= BaseProperties.getEnvironment("dbnames").split(","),
                DB = BaseProperties.getEnvironment("DBSofts").split(",");
        dm = new jdbcClient[hosts.length];

        for (int i = 0; i < hosts.length; i++) {
            dm[i] = new jdbcClient(DB[i], hosts[i], ports[i], dbnames[i], users[i], passes[i]);
        }
        init = BaseProperties.getBool("createTable");
        vacuum = BaseProperties.getBool("vacuum");
        insert = BaseProperties.getInt("insert");
        select = BaseProperties.getInt("select");
        update = BaseProperties.getInt("update");
    }

    public void startTest() {
        if (init) {
            for (int i = 0; i < dm.length; i++) {
                dm[i].runDDL(createSQLs);
            }
        } else if (vacuum) {
            makeVacuum();
        }

        for (int i = 0; i < insert; i++) {
            String insertSQL = this.creater.makeinsert(insertNumber);
            System.out.println("第"+i+"次运行insert测试：");
            RunInsertTest(insertSQL);
        }
        System.out.println();

        for (int i = 0; i < select; i++) {
            SelectUpdateBox box = MakeSQLBox.getSQLBox(ts);
            System.out.println("第"+i+"次运行select测试，测试SQL："+box.getSelectSQL());
            RunSelectTest(box.getSelectSQL());
        }
        System.out.println();

        for (int i = 0; i < update; i++) {
            SelectUpdateBox box = MakeSQLBox.getSQLBox(ts);
            System.out.println("第"+i+"次运行update测试，测试SQL："+box.getUpdateSQL());
            System.out.println("该SQL影响范围："+dm[0].getUpdateExplain(box.getSelectRangeSQL()));
            RunUpdateTest(box);
        }
        System.out.println();
    }

    private void makeVacuum() {
        for (int i = 0; i < dm.length; i++) {
            dm[i].runUpdate("delete from " + ts.getTbname());
        }
    }

    private void RunInsertTest(String SQL) {
        long nanoTime[] = new long[dm.length];
        int operate[] = new int[dm.length];
        for (int j = 0; j < dm.length; j++) {
            long res = dm[j].runUpdate(SQL);
            if (res > 0l) {
                nanoTime[j] += res;
                operate[j]++;
                System.out.println(dm[j].getConnMsg()+" 运行时长："+(res/1000000000d));
            }
            else{
                System.out.println(dm[j].getConnMsg()+" 本次运行失败");
            }
        }

    }

    private void RunSelectTest(String SQL) {
        long nanoTime[] = new long[dm.length];
        int operate[] = new int[dm.length];
        for (int j = 0; j < dm.length; j++) {
            long res = dm[j].runSelect(SQL);
            if (res > 0l) {
                nanoTime[j] += res;
                operate[j]++;
                System.out.println(dm[j].getConnMsg()+" 运行时长："+(res/1000000000d));
            }
            else{
                System.out.println(dm[j].getConnMsg()+" 本次运行失败");
            }
        }

    }

    private void RunUpdateTest(SelectUpdateBox box) {
        long nanoTime[] = new long[dm.length];
        int operate[] = new int[dm.length];
        for (int j = 0; j < dm.length; j++) {
            long res = dm[j].runUpdate(box.getUpdateSQL());
            if (res > 0l) {
                nanoTime[j] += res;
                operate[j]++;
                System.out.println(dm[j].getConnMsg()+" 运行时长："+(res/1000000000d));
            }
            else{
                System.out.println(dm[j].getConnMsg()+" 本次运行失败");
            }
        }

    }
}
