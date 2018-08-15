package Utils.insert;

import Utils.DataCreater.RandomAdvanceDataCreater;
import Utils.DataCreater.RandomBasicDataCreater;
import Utils.StringSpecificationOutput;
import Utils.env_properties;
import Utils.privateRandom;
import dataStruture.ListStructure;
import dataStruture.TableStructure;
import java.util.*;

public class InsertSQLCreater implements Runnable{

    private String tablename;
    private TableStructure tableStructure;
    private double makenumber;
    private tF writer;
    private RandomBasicDataCreater rbdc;
    private RandomAdvanceDataCreater radc;

    private Map<String,List> unique;
    public InsertSQLCreater(String tablename, TableStructure tableStructure,double makenumber,tF writer){
        this.tablename=tablename;
        this.tableStructure=tableStructure;
        this.makenumber=makenumber;
        this.writer=writer;
        rbdc=new RandomBasicDataCreater(tableStructure.getMaxListRange());
        this.radc=new RandomAdvanceDataCreater(rbdc);
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
        StringBuffer table=new StringBuffer();
        StringBuffer values=new StringBuffer();

            if(env_properties.getEnvironment("toDB").equals("sql")||
                    env_properties.getEnvironment("toDB").equals("jdbc")) {
                values.append(" values(");
                table.append("insert into ");
                table.append(tablename);
                if(tableStructure.isUnmake()) {
                    table.append('(');
                    table.append(tableStructure.getListnames());
                    table.append(')');
                }
            }
            else if(env_properties.getEnvironment("toDB").equals("json")){
                values.insert(0,'{');
            }
        while (tableStructure.hasNext())
        {
            ListStructure ls=tableStructure.getNextStruc();
            if(ls.isUnmake())
                continue;
            String appendStr=null;
            if(ls.isInline()) {//inline覆盖掉所有其他设置
                int num=privateRandom.RandomNumber(0,ls.getInlinelength()).intValue();
                switch (ls.getListType())
                {
                    case "number":
                        appendStr=StringSpecificationOutput.specNumber(
                                ls.getInlineObject(num),ls.getRange()[0],ls.getRange()[1]);
                        break;
                    case "date":
                        appendStr=StringSpecificationOutput.specDate(
                                ls.getInlineObject(num));
                        break;
                    case "bool":
                        appendStr=StringSpecificationOutput.specBool(ls.getInlineObject(num));
                        break;
                    case "string":
                    default:
                        appendStr=StringSpecificationOutput.specString(
                                ls.getInlineObject(num),ls.getRange()[0]);
                        break;
                }
            }
            else if((!ls.isSingal())&&ls.isDefault()&& privateRandom.RandomNumber(0,1)<=2*Double.valueOf(env_properties.getEnvironment("defaultProportion"))){
                //当存在类似唯一约束的情况时将屏蔽默认值
                switch (ls.getListType())
                {
                    case "number":
                        appendStr=StringSpecificationOutput.specNumber(
                                ls.getDefaultStr(),ls.getRange()[0],ls.getRange()[1]);
                        break;
                    case "date":
                        appendStr= StringSpecificationOutput.specDate(
                                ls.getDefaultStr());
                        break;
                    case "bool":
                        appendStr=StringSpecificationOutput.specBool(
                                ls.getDefaultStr());
                        break;
                    case "string":
                    default:
                        appendStr=StringSpecificationOutput.specString(
                                ls.getDefaultStr(),ls.getRange()[0]);
                        break;
                }
            }
            else if(ls.getDefaultType().equals("")){
                switch (ls.getListType())
                {
                    case "number":
                        appendStr=rbdc.getNumber(ls.getRange()[0],ls.getRange()[1],ls.getNumberarea());
                        break;
                    case "date":
                        appendStr=rbdc.getDate(true);
                        break;
                    case "bool":
                        appendStr=rbdc.getBool();
                        break;
                    case "string":
                    default:
                        appendStr=StringSpecificationOutput.specString(
                                rbdc.getStr(ls.getRange()[0]),ls.getRange()[0]);
                        break;
                }

                addtoSet(ls,appendStr);
            }
            else{
                if (!ls.getListType().equals("string"))
                    throw new Exception("非字符串类型不能使用stringtype关键字");
                appendStr=StringSpecificationOutput.specString(
                        radc.returnAdvancedString(ls.getDefaultType(),ls.getRange()[0]),ls.getRange()[0]);
                addtoSet(ls,appendStr);
            }

            if(env_properties.getEnvironment("toDB").equals("json")) {
                values.append("\n\"");
                values.append(ls.getListname());
                values.append("\": ");
            }
            values.append(appendStr);
            values.append(',');
        }
        values.deleteCharAt(values.length()-1);
        if(env_properties.getEnvironment("toDB").equals("sql")||
                env_properties.getEnvironment("toDB").equals("jdbc")) {
            values.append(");");
        }
        else if(env_properties.getEnvironment("toDB").equals("json")){
            values.append("\n}");
        }
        writer.WriteLine(table.append(values).toString());
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
