package Utils.DataCreater.FiledCreater;

import dataStruture.ListStructure;
import dataStruture.TableStructure;

public class MongoCreater extends baseCreater {
    public MongoCreater(TableStructure tableStructure) {
        super(tableStructure);
    }

    @Override
    protected String packHead(boolean isUnmake) {
        return "db." + tableStructure.getTbname() + ".insert({";
    }

    @Override
    protected void packFiled(ListStructure list, StringBuilder out, String appendStr) {
        out.append("\n\"").append(list.getListname()).append("\":");
        switch (list.getListType()) {
            case "string":
            case "date":
                out.append('\"').append(appendStr).append("\"");
                break;
            default:
                out.append(appendStr);
                break;
        }
        out.append(',');
    }

    @Override
    protected String packTail() {
        return "})\n";
    }
}
