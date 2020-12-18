package DataCreater.FiledCreater;

import dataStructure.RuntimeEnvironment;
import dataStructure.TableStructure;

public class SQLFiledCreater extends baseFiledCreater {
    public SQLFiledCreater(TableStructure tableStructure, RuntimeEnvironment env) {
        super(tableStructure,env);
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
    protected String packFiled() {
        StringBuilder out=new StringBuilder();
        out.append('(');
        for (String appendStr:super.makeOnceData()) {
            out.append(appendStr);
            out.append(',');
        }
        out.deleteCharAt(out.length()-1);
        out.append(')').append(',');
        return out.toString();
    }

    @Override
    protected String packTail() {
        return ";\n";
    }
}
