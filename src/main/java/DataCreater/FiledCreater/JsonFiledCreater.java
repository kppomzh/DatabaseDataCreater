package DataCreater.FiledCreater;

import dataStructure.ListStructure;
import dataStructure.TableStructure;

public class JsonFiledCreater extends baseFiledCreater {
//    private HashMap<String,Object> k_vMap;

    public JsonFiledCreater(TableStructure tableStructure) {
        super(tableStructure);
//        k_vMap=new HashMap<>();
    }

    @Override
    protected String packHead(boolean isUnmake) {
        return "";
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

                out.append("\n\"").append(list.getListname()).append("\": ").append(appendStr).append(",");
            }
        }
        out.deleteCharAt(out.length()-1);
        out.append("\n}\n");
    }

    @Override
    protected String packTail() {
        return "";
    }
}
