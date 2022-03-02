package com.zhzm.datacreater.line;

import com.facebook.presto.jdbc.internal.jackson.core.JsonProcessingException;
import com.facebook.presto.jdbc.internal.jackson.databind.ObjectMapper;
import com.zhzm.datacreater.table.TableMaker;

public class MongoFiledCreater extends BaseFiledCreater {
    private ObjectMapper objectMapper;
    public MongoFiledCreater(TableMaker maker) {
        super(maker);
        objectMapper = new ObjectMapper();
    }

    @Override
    protected String packHead() {
        return "db." + tableMaker.getTablename() + ".insert([";
    }

    @Override
    protected String packFiled() {
        try {
            return objectMapper.writeValueAsString(super.makeOnceData())+',';
        } catch (JsonProcessingException e) {
            return "{},";
        }
    }

    @Override
    protected String packTail() {
        return "])\n";
    }
}
