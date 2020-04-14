package DataCreater.FiledCreater;

import dataStructure.ListStructure;
import dataStructure.TableStructure;

public class csvFiledCreater extends baseFiledCreater {
    public csvFiledCreater(TableStructure tableStructure) {
        super(tableStructure);
    }

    @Override
    protected String packHead(boolean isUnmake) {
        return "";
    }

    @Override
    protected void packFiled(TableStructure table, StringBuilder out) {
        ListStructure list;
        String appendStr;

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
        out.append('\n');
    }

    @Override
    protected String packTail() {
        return "";
    }
}
