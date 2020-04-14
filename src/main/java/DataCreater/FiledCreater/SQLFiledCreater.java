package DataCreater.FiledCreater;

import Utils.StringSpecificationOutput;
import dataStructure.ListStructure;
import dataStructure.TableStructure;

public class SQLFiledCreater extends baseFiledCreater {
    public SQLFiledCreater(TableStructure tableStructure) {
        super(tableStructure);
    }

    @Override
    protected String packHead(boolean isUnmake) {
        StringBuilder table = new StringBuilder("insert into ");
        table.append(tableStructure.getTbname());
        if (isUnmake) {
            table.append('(');
            table.append(tableStructure.getListnames());
            table.append(')');
        }
        return table.append(" values").toString();
    }

    @Override
    protected void packFiled(TableStructure table, StringBuilder out) {
        ListStructure list;
        String appendStr;

        out.append('(');
        while (this.tableStructure.hasNext()) {
            list = tableStructure.getNextStruc();
            if (list.isUnmake()) {
                continue;
            }
            else {
                appendStr = list.getString();
                while (!addtoSet(list, appendStr)) {
                    appendStr = list.getString();
                }
            }
            out.append(appendStr);
            out.append(',');
        }
        out.deleteCharAt(out.length()-1);
        out.append(')').append(',');
    }

    @Override
    protected String packTail() {
        return ";";
    }
}
