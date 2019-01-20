package Utils.DataCreater.FiledCreater;

import Utils.DataCreater.StringSpecificationOutput;
import dataStructure.ListStructure;
import dataStructure.TableStructure;

public class SQLCreater extends baseCreater {
    public SQLCreater(TableStructure tableStructure) {
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
        return table.append(" values(").toString();
    }

    @Override
    protected void packFiled(ListStructure list, StringBuilder out, String appendStr) {
        switch (list.getListType()) {
            case "date":
                out.append(StringSpecificationOutput.specDate(appendStr));
                break;
            case "string":
                out.append("\'").append(appendStr).append("\'");
                break;
            default:
                out.append(appendStr);
                break;
        }
        out.append(',');
    }

    @Override
    protected String packTail() {
        return ");";
    }
}
