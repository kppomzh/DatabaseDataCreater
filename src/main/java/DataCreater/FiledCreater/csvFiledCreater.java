package DataCreater.FiledCreater;

import dataStructure.TableStructure;

public class csvFiledCreater extends baseFiledCreater {
    public csvFiledCreater(TableStructure tableStructure) {
        super(tableStructure);
    }

    @Override
    protected String packHead() {
        return "";
    }

    @Override
    protected void packFiled(StringBuilder out) {
        for (String appendStr:super.makeOnceData()) {
            out.append(appendStr);
            out.append(',');
        }
        out.deleteCharAt(out.length()-1);
        out.append('\n');
    }

    @Override
    protected String packTail() {
        return "";
    }
}
