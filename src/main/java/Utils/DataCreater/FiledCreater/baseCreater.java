package Utils.DataCreater.FiledCreater;

import Utils.DataCreater.RandomAdvanceDataCreater;
import Utils.DataCreater.RandomBasicDataCreater;
import Utils.StringSpecificationOutput;
import Utils.env_properties;
import Utils.privateRandom;
import dataStruture.ListStructure;
import dataStruture.TableStructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class baseCreater {
    private RandomBasicDataCreater rbdc;
    private RandomAdvanceDataCreater radc;
    protected TableStructure tableStructure;
    private Map<String, List> unique;

    public baseCreater(TableStructure tableStructure) {
        for (ListStructure ls : tableStructure.getStruc()) {
            if (ls.isSingal()) {
                unique.put(ls.getListname(), new ArrayList());
            }
        }

        this.tableStructure = tableStructure;
        this.rbdc = new RandomBasicDataCreater(tableStructure.getMaxListRange());
        this.radc = new RandomAdvanceDataCreater(rbdc);
        this.unique = new HashMap<>();
    }


    public String makeinsert() throws Exception {
        StringBuilder Return = new StringBuilder(packHead(tableStructure.isUnmake()));
        while (this.tableStructure.hasNext()) {
            ListStructure ls = tableStructure.getNextStruc();
            if (ls.isUnmake())
                continue;
            String appendStr = strSpecification(ls, makeFiled(ls));
            addtoSet(ls, appendStr);

            packFiled(ls, Return, appendStr);
        }
        Return.deleteCharAt(Return.length() - 1);
        return Return.append(packTail()).append("\n").toString();
    }

    protected String strSpecification(ListStructure ls, String appendStr) {
        switch (ls.getListType()) {
            case "number":
                return StringSpecificationOutput.specNumber(appendStr, ls.getRange()[0], ls.getRange()[1]);
            case "bool":
                return StringSpecificationOutput.specBool(appendStr);
            case "string":
                return StringSpecificationOutput.specString(
                        appendStr, ls.getRange()[0]);
            default:
                return null;
        }
    }

    protected void addtoSet(ListStructure ls, String appendStr) throws Exception {
        if (ls.isSingal()) {
            if (unique.get(ls.getListname()).contains(appendStr))
                throw new Exception("ta");
            else
                unique.get(ls.getListname()).add(appendStr);
        }
    }

    private String makeFiled(ListStructure ls) throws Exception {
        String appendStr = null;
        if (ls.isInline()) {//inline覆盖掉所有其他设置
            int num = privateRandom.RandomNumber(0, ls.getInlinelength()).intValue();
            appendStr = ls.getInlineObject(num);
        } else if ((!ls.isSingal()) && ls.isDefault() && privateRandom.RandomNumber(0, 1) <= 2 * Double.valueOf(env_properties.getEnvironment("defaultProportion"))) {
            appendStr = ls.getDefaultStr();//当存在类似唯一约束的情况时将屏蔽默认值
        } else if (ls.getDefaultType().equals("")) {
            switch (ls.getListType()) {
                case "number":
                    appendStr = rbdc.getNumber(ls.getRange()[0], ls.getRange()[1], ls.getNumberarea());
                    break;
                case "date":
                    appendStr = rbdc.getDate(true);
                    break;
                case "bool":
                    appendStr = rbdc.getBool();
                    break;
                case "string":
                default:
                    appendStr = StringSpecificationOutput.specString(
                            rbdc.getStr(ls.getRange()[0]), ls.getRange()[0]);
                    break;
            }
        } else {
            if (!ls.getListType().equals("string"))
                throw new Exception("非字符串类型不能使用stringtype关键字");
            appendStr = radc.returnAdvancedString(ls.getDefaultType(), ls.getRange()[0]);
        }
        return appendStr;
    }

    protected abstract String packHead(boolean isUnmake);

    protected abstract void packFiled(ListStructure list, StringBuilder out, String appendStr);

    protected abstract String packTail();
}
