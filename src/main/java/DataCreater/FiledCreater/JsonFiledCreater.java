package DataCreater.FiledCreater;

import dataStructure.RuntimeEnvironment;
import dataStructure.TableStructure;

public class JsonFiledCreater extends baseFiledCreater {
//    private HashMap<String,Object> k_vMap;

    public JsonFiledCreater(TableStructure tableStructure, RuntimeEnvironment env) {
        super(tableStructure,env);
//        k_vMap=new HashMap<>();
    }

    @Override
    protected String packHead() {
        return "";
    }

    @Override
    protected String packFiled() {
        StringBuilder out=new StringBuilder();
        out.append('{');
        String[] temp=super.makeOnceData();
        for (int i = 0; i < temp.length; i++) {
            String appendStr=temp[i];
            out.append("\n\"").append(toMakeInserts[i].getListname()).append("\": ").append(appendStr).append(",");
        }
        out.deleteCharAt(out.length()-1);
        out.append("\n}\n");
        return out.toString();
    }

    @Override
    protected String packTail() {
        return "\n";
    }
}
