package Utils.DataCreater.FiledCreater;

import dataStructure.ListStructure;
import dataStructure.TableStructure;

public class JsonCreater extends baseCreater {
    public JsonCreater(TableStructure tableStructure) {
        super(tableStructure);
    }

    @Override
    protected String packHead(boolean isUnmake) {
        return "{";
    }

    @Override
    protected void packFiled(ListStructure list, StringBuilder out, String appendStr) {
        out.append("\n\"").append(list.getListname()).append("\": \"").append(appendStr).append("\",");
    }

    @Override
    protected String packTail() {
        return "\n}";
    }
}
