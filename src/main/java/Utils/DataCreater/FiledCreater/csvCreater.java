package Utils.DataCreater.FiledCreater;

import dataStructure.ListStructure;
import dataStructure.TableStructure;

public class csvCreater extends baseCreater {
    public csvCreater(TableStructure tableStructure) {
        super(tableStructure);
    }

    @Override
    protected String packHead(boolean isUnmake) {
        return "";
    }

    @Override
    protected void packFiled(ListStructure list, StringBuilder out, String appendStr) {
        switch (list.getListType()) {
            case "string":
            case "date":
                out.append('\'').append(appendStr).append("\'");
                break;
            default:
                out.append(appendStr);
                break;
        }
        out.append(',');
    }

    @Override
    protected String packTail() {
        return "";
    }
}
