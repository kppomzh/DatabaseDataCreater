package Utils.insert;

import Utils.DataCreater.RandomAdvanceDataCreater;
import Utils.DataCreater.RandomBasicDataCreater;
import Utils.env_properties;
import Utils.privateRandom;
import dataStruture.ListStructure;
import dataStruture.TableStructure;
import java.lang.reflect.Method;
import java.util.*;

public class InsertSQLCreater implements Runnable{

    private String tablename;
    private TableStructure tableStructure;
    private double makenumber;
    private tF writer;
    private RandomAdvanceDataCreater radc;

    private Map<String,List> unique;
    public InsertSQLCreater(String tablename, TableStructure tableStructure,double makenumber,tF writer){
        this.tablename=tablename;
        this.tableStructure=tableStructure;
        this.makenumber=makenumber;
        this.writer=writer;
        this.radc=new RandomAdvanceDataCreater();
        this.unique=new HashMap<>();
    }

    @Override
    public void run() {
        for(ListStructure ls:tableStructure.getStruc())
        {
            if(ls.isSingal())
            {
                unique.put(ls.getListname(),new ArrayList());
            }
        }
        for(double loop=0;loop<makenumber;loop++) {
            try {
                makeainsert();
            } catch (Exception e) {
                if(e.getMessage().equals("ta")){
                    loop--;
                    continue;
                }
                else
                    throw new RuntimeException(e.getMessage());
            }
        }
    }

    private void makeainsert()  {
        try {
        StringBuffer sb=new StringBuffer();
        while (tableStructure.hasNext())
        {
            ListStructure ls=tableStructure.getNextStruc();
            String appendStr=null;
            if((!ls.isSingal())&&ls.isDefault()&& privateRandom.RandomNumber(0,1)<=2*Double.valueOf(env_properties.getEnvironment("defaultProportion"))){
                //当存在类似唯一约束的情况时将屏蔽默认值
                switch (ls.getListType())
                {
                    case "number":
                        appendStr=Double.valueOf(ls.getDefaultStr()).toString();//根本目的是进行一轮检查
                        break;
                    case "date":
                        appendStr="sysdate";//这里暂时只能用sysdate凑数了 _(:3」∠)_
                        break;
                    case "bool":
                        appendStr=ls.getDefaultStr();//bool值暂时也没办法检查合法性 _(:3」∠)_
                        break;
                    case "string":
                    default:
                        appendStr=ls.getDefaultStr();
                        if(env_properties.getEnvironment("toDB").equals("sql")||
                                env_properties.getEnvironment("toDB").equals("jdbc")) {
                            appendStr= '\''+appendStr+'\'';
                        }
                        break;
                }
            }
            else if(ls.getDefaultType().equals("")){
                switch (ls.getListType())
                {
                    case "number":
                        appendStr=RandomBasicDataCreater.getNumber(ls.getRange()[0],ls.getRange()[1],true);
                        break;
                    case "date":
                        appendStr=RandomBasicDataCreater.getDate(true);
                        break;
                    case "bool":
                        appendStr=RandomBasicDataCreater.getBool();
                        break;
                    case "string":
                    default:
                        appendStr=RandomBasicDataCreater.getStr(ls.getRange()[0]);
                        break;
                }

                addtoSet(ls,appendStr);
            }
            else{
                if (!ls.getListType().equals("string"))
                    throw new Exception("非字符串类型不能使用stringtype关键字");
                appendStr=radc.returnAdvancedString(ls.getDefaultType(),ls.getRange()[0]);
                addtoSet(ls,appendStr);
            }

            if(env_properties.getEnvironment("toDB").equals("json")) {
                sb.append("\n\"");
                sb.append(ls.getListname());
                sb.append("\": ");
            }
            sb.append(appendStr);
            sb.append(',');
        }
        sb.deleteCharAt(sb.length()-1);
        if(env_properties.getEnvironment("toDB").equals("sql")||
                env_properties.getEnvironment("toDB").equals("jdbc")) {
            sb.insert(0," values(");
            sb.insert(0,tablename);
            sb.insert(0,"insert into ");
            sb.append(");");
        }
        else if(env_properties.getEnvironment("toDB").equals("json")){
            sb.insert(0,'{');
            sb.append("\n}");
        }
        writer.WriteLine(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addtoSet(ListStructure ls,String appendStr) throws Exception {
        if(ls.isSingal()) {
            if(unique.get(ls.getListname()).contains(appendStr))
                throw new Exception("ta");
            else
                unique.get(ls.getListname()).add(appendStr);
        }
    }
}
