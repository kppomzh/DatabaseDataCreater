package Utils.DataCreater.FiledCreater;

import dataStructure.ListStructure;
import dataStructure.TableStructure;

public class MongoCreater extends baseCreater {
    public MongoCreater(TableStructure tableStructure) {
        super(tableStructure);
    }

    @Override
    protected String packHead(boolean isUnmake) {
        return "db." + tableStructure.getTbname() + ".insert(";
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
            while(!addtoSet(list, appendStr)){
                appendStr = strSpecification(list, makeFiled(list));
            }

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
        out.deleteCharAt(out.length() - 1);
        out.append('}').append(',');
    }

    @Override
    protected String packTail() {
        return ")\n";
    }
}
