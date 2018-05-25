package Utils.insert;

import Utils.DataCreater.RandomAdvanceDataCreater;
import Utils.DataCreater.RandomBasicDataCreater;
import Utils.env_properties;
import dataStruture.ListStructure;
import dataStruture.TableStructure;

public class InsertSQLCreater implements Runnable{

    private String tablename;
    private TableStructure tableStructure;
    private double makenumber;
    private tF writer;
    public InsertSQLCreater(String tablename, TableStructure tableStructure,double makenumber,tF writer){
        this.tablename=tablename;
        this.tableStructure=tableStructure;
        this.makenumber=makenumber;
        this.writer=writer;
    }

    @Override
    public void run() {
        for(double loop=0;loop<makenumber;loop++) {
            try {
                makeainsert();
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }
    }

    private void makeainsert() throws Exception {
        StringBuffer sb=new StringBuffer();
        while (tableStructure.hasNext())
        {
            ListStructure ls=tableStructure.getNextStruc();
            if(ls.getDefaultType().equals("")){
                switch (ls.getListType())
                {
                    case "number":
                        sb.append(RandomBasicDataCreater.getNumber(ls.getRange()[0],ls.getRange()[1],true));
                        break;
                    case "date":
                        sb.append(RandomBasicDataCreater.getDate(true));
                        break;
                    case "string":
                    default:
                        sb.append(RandomBasicDataCreater.getStr(ls.getRange()[0]));
                        break;
                }
            }
            else{
                if (!ls.getListType().equals("string"))
                    throw new Exception("非字符串类型不能使用stringtype关键字");
                switch (ls.getDefaultType()){
                    case "idcard":
                        sb.append(RandomAdvanceDataCreater.chineseIDNumber(ls.getRange()[0]));
                        break;
                    case "email":
                        sb.append(RandomAdvanceDataCreater.emailAddress(ls.getRange()[0]));
                        break;
                    case "tele":
                        sb.append(RandomAdvanceDataCreater.telephoneNumber(ls.getRange()[0]));
                        break;
                    default:
                        sb.append(RandomAdvanceDataCreater.freeStringType(ls.getRange()[0],ls.getDefaultType()));
                        break;
                }
            }
            sb.append(',');
        }
        sb.deleteCharAt(sb.length()-1);
        if(env_properties.getEnvironment("toDB").equals("file")||
                env_properties.getEnvironment("toDB").equals("jdbc")) {
            sb.insert(0," values(");
            sb.insert(0,tablename);
            sb.insert(0,"insert into ");
            sb.append(");");
        }
        writer.WriteLine(sb.toString());
    }
}
