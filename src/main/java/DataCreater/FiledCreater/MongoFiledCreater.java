package DataCreater.FiledCreater;

import dataStructure.RuntimeEnvironment;
import dataStructure.TableStructure;

public class MongoFiledCreater extends baseFiledCreater {
    public MongoFiledCreater(TableStructure tableStructure, RuntimeEnvironment env) {
        super(tableStructure,env);
    }

    @Override
    protected String packHead() {
        return "db." + tableStructure.getTbname() + ".insert(";
    }

    @Override
    protected String packFiled() {
        StringBuilder out=new StringBuilder();
        out.append('{');
        String[] temp=super.makeOnceData();
        for (int i = 0; i < temp.length; i++) {
            String appendStr=temp[i];
            out.append("\n\"").append(toMakeInserts[i].getListname()).append("\":");
            out.append(appendStr).append(',');

        }
        out.deleteCharAt(out.length() - 1);
        out.append('}').append(',');
        return out.toString();
    }

    @Override
    protected String packTail() {
        return ")\n";
    }
}
