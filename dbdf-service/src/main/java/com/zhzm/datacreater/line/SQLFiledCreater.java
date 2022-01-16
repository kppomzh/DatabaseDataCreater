package com.zhzm.datacreater.line;

import com.zhzm.datacreater.table.TableMaker;

public class SQLFiledCreater extends baseFiledCreater {
    public SQLFiledCreater(TableMaker maker) {
        super(maker);
    }

    @Override
    protected String packHead() {
        StringBuilder table = new StringBuilder("insert into ");
        table.append(tableMaker.getTablename());
        table.append(tableMaker.getListnamessb());
        return table.append(" values").toString();
    }

    @Override
    protected String packFiled() {
        StringBuilder out=new StringBuilder();
        out.append('(');
        for (String appendStr:super.makeOnceData().values()) {
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
