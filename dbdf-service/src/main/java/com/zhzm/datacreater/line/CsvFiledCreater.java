package com.zhzm.datacreater.line;


import com.zhzm.datacreater.table.TableMaker;

public class CsvFiledCreater extends BaseFiledCreater {
    public CsvFiledCreater(TableMaker maker) {
        super(maker);
    }

    @Override
    protected String packHead() {
        return "";
    }

    @Override
    protected String packFiled() {
        StringBuilder out=new StringBuilder();
        for (String appendStr:super.makeOnceData().values()) {
            out.append(appendStr);
            out.append(',');
        }
        out.deleteCharAt(out.length()-1);
        out.append('\n');
        return out.toString();
    }

    @Override
    protected String packTail() {
        return "\n";
    }
}
