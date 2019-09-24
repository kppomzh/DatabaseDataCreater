package Utils.DataCreater.FiledCreater;

import dataStructure.ListStructure;
import dataStructure.TableStructure;

import java.util.HashMap;

public class JsonCreater extends baseCreater {
//    private HashMap<String,Object> k_vMap;

    public JsonCreater(TableStructure tableStructure) {
        super(tableStructure);
//        k_vMap=new HashMap<>();
    }

    @Override
    protected String packHead(boolean isUnmake) {
        return "";
    }

    @Override
    protected void packFiled(TableStructure table, StringBuilder out) throws Exception {
        ListStructure list;
        String appendStr;

        out.append('{');
        while (this.tableStructure.hasNext()) {
            list = tableStructure.getNextStruc();
            if (list.isUnmake()) {
                continue;
            }
            appendStr = strSpecification(list, makeFiled(list));
            while (!addtoSet(list, appendStr)) {
                appendStr = strSpecification(list, makeFiled(list));
            }

            out.append("\n\"").append(list.getListname()).append("\": \"").append(appendStr).append("\",");
        }
        out.deleteCharAt(out.length()-1);
        out.append("\n}\n");
    }

    @Override
    protected String packTail() {
        return "";
    }
}
