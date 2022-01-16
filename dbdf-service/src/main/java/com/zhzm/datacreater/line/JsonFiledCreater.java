package com.zhzm.datacreater.line;

import com.facebook.presto.jdbc.internal.jackson.core.JsonProcessingException;
import com.facebook.presto.jdbc.internal.jackson.databind.ObjectMapper;
import com.zhzm.datacreater.table.TableMaker;

public class JsonFiledCreater extends baseFiledCreater {
    private ObjectMapper objectMapper;

    public JsonFiledCreater(TableMaker maker) {
        super(maker);
        objectMapper=new ObjectMapper();
    }

    @Override
    protected String packHead() {
        return "";
    }

    @Override
    protected String packFiled() {
        try {
            return objectMapper.writeValueAsString(super.makeOnceData())+'\n';
        } catch (JsonProcessingException e) {
            return "{},";
        }
    }

    @Override
    protected String packTail() {
        return "\n";
    }
}
