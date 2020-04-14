package DataCreater.FiledCreater;

import dataStructure.ListStructure;
import dataStructure.TableStructure;

public class MongoFiledCreater extends baseFiledCreater {
    public MongoFiledCreater(TableStructure tableStructure) {
        super(tableStructure);
    }

    @Override
    protected String packHead(boolean isUnmake) {
        return "db." + tableStructure.getTbname() + ".insert(";
    }

    @Override
    protected void packFiled(TableStructure table, StringBuilder out) {
        ListStructure list;
        String appendStr;

        out.append('{');
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

                out.append("\n\"").append(list.getListname()).append("\":");
                out.append(appendStr).append(',');
            }
        }
        out.deleteCharAt(out.length() - 1);
        out.append('}').append(',');
    }

    @Override
    protected String packTail() {
        return ")\n";
    }
}
