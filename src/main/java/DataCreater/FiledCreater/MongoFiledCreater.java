package DataCreater.FiledCreater;

import dataStructure.TableStructure;

public class MongoFiledCreater extends baseFiledCreater {
    public MongoFiledCreater(TableStructure tableStructure) {
        super(tableStructure);
    }

    @Override
    protected String packHead() {
        return "db." + tableStructure.getTbname() + ".insert(";
    }

    @Override
    protected void packFiled(StringBuilder out) {
        out.append('{');
        String[] temp=super.makeOnceData();
        for (int i = 0; i < temp.length; i++) {
            String appendStr=temp[i];
            out.append("\n\"").append(toMakeInserts[i].getListname()).append("\":");
            out.append(appendStr).append(',');

        }
        out.deleteCharAt(out.length() - 1);
        out.append('}').append(',');
    }

    @Override
    protected String packTail() {
        return ")\n";
    }
}
