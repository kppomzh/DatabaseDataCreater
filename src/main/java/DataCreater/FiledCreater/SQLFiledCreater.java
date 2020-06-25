package DataCreater.FiledCreater;

import dataStructure.TableStructure;

public class SQLFiledCreater extends baseFiledCreater {
    public SQLFiledCreater(TableStructure tableStructure) {
        super(tableStructure);
    }

    @Override
    protected String packHead() {
        StringBuilder table = new StringBuilder("insert into ");
        table.append(tableStructure.getTbname());
        if (tableStructure.isUnmake()) {
            table.append('(');
            table.append(tableStructure.getListnames());
            table.append(')');
        }
        return table.append(" values").toString();
    }

    @Override
    protected void packFiled(StringBuilder out) {
        out.append('(');
        for (String appendStr:super.makeOnceData()) {
            out.append(appendStr);
            out.append(',');
        }
        out.deleteCharAt(out.length()-1);
        out.append(')').append(',');
    }

    @Override
    protected String packTail() {
        return ";";
    }
}
