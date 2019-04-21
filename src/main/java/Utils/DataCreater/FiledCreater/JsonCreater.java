package Utils.DataCreater.FiledCreater;

import dataStructure.ListStructure;
import dataStructure.TableStructure;

import java.util.HashMap;

public class JsonCreater extends baseCreater {
//    private HashMap<String,Object> k_vMap;

    public JsonCreater(TableStructure tableStructure) {
        super(tableStructure);
//        k_vMap=new HashMap<>();
    }

    @Override
    protected String packHead(boolean isUnmake) {
//        return ",";
        return "{";
    }

    @Override
    protected void packFiled(ListStructure list, StringBuilder out, String appendStr) {
//        k_vMap.put(list.getListname(),appendStr);
        out.append("\n\"").append(list.getListname()).append("\": \"").append(appendStr).append("\",");
    }

    @Override
    protected String packTail() {
//        return JSON.toJSONString(k_vMap);
        return "\n}";
    }
}
