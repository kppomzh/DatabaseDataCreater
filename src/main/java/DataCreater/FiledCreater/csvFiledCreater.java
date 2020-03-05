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
    protected void packFiled(TableStructure table, StringBuilder out) throws Exception {
        ListStructure list;
        String appendStr;

        while (this.tableStructure.hasNext()) {
            list = tableStructure.getNextStruc();
            if (list.isUnmake()) {
                continue;
            }
            else {
                appendStr = strSpecification(list, makeFiled(list));
                while (!addtoSet(list, appendStr)) {
                    appendStr = strSpecification(list, makeFiled(list));
                }

                switch (list.getListType()) {
                    case "string":
                    case "date":
                        out.append('\'').append(appendStr).append("'");
                        break;
                    default:
                        out.append(appendStr);
                        break;
                }
            }
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
