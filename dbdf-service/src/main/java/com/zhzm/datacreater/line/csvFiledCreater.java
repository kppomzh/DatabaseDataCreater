package com.zhzm.datacreater.line;


import com.zhzm.datacreater.table.TableMaker;
import com.zhzm.datastructure.table.TableStructure;

public class csvFiledCreater extends baseFiledCreater {
    public csvFiledCreater(TableMaker maker) {
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
