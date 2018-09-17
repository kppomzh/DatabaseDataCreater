package Utils.DataCreater;

import Utils.DataCreater.FiledCreater.*;
import Utils.DataCreater.RandomAdvanceDataCreater;
import Utils.DataCreater.RandomBasicDataCreater;
import Utils.StringSpecificationOutput;
import Utils.env_properties;
import Utils.insert.tF;
import Utils.privateRandom;
import dataStruture.ListStructure;
import dataStruture.TableStructure;

import java.util.*;

public class InsertSQLCreater implements Runnable {

    private double makenumber;
    private tF writer;

    private baseCreater bc;

    public InsertSQLCreater(String tablename, TableStructure tableStructure, double makenumber, tF writer) {
        this.makenumber = makenumber;
        this.writer = writer;
        switch (env_properties.getEnvironment("toDB")) {
            case "csv":
                bc = new csvCreater(tableStructure);
                break;
            case "jdbc":
            case "sql":
                bc = new SQLCreater(tableStructure);
                break;
            case "json":
                bc = new JsonCreater(tableStructure);
                break;
            case "mongo":
                bc = new MongoCreater(tableStructure);
                break;
        }
    }

    @Override
    public void run() {
        for (double loop = 0; loop < makenumber; loop++) {
            try {
                String toWrite = bc.makeinsert();
                writer.WriteLine(toWrite);
            } catch (Exception e) {
                if (e.getMessage().equals("ta")) {
                    loop--;
                    continue;
                } else
                    throw new RuntimeException(e.getMessage());
            }
        }
    }
}
