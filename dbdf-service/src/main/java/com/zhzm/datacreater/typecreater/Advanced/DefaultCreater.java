package com.zhzm.datacreater.typecreater.Advanced;

import com.zhzm.datacreater.typecreater.baseTypeCreater;
import com.zhzm.datacreater.typecreater.baseTypeCreaterImpl;
import com.zhzm.datastructure.table.ListStructure;
import com.zhzm.utils.BaseEnvironment;
import com.zhzm.utils.StringSpecificationOutput;
import com.zhzm.utils.privateRandom;

public class DefaultCreater extends baseTypeCreaterImpl {
    private String DefaultStr;
    private baseTypeCreater innerCreater;
    private double Proportion;

    public DefaultCreater(baseTypeCreater creater, ListStructure list, double Proportion){
//        super(list.isRely());
        innerCreater=creater;
        this.Proportion=Proportion;

        if("sql".equals(BaseEnvironment.getEnvironment("toDB")) && list.getListType().equals("date")){
            DefaultStr=StringSpecificationOutput.specDate(list.getDefaultStr());
        }
        else if(list.getListType().equals("string")){
            DefaultStr='\''+ StringSpecificationOutput.specString(list.getDefaultStr(),list.getRange()[0])+'\'';
        }
        else if(list.getListType().equals("number")) {
            this.DefaultStr=StringSpecificationOutput.specNumber(list.getDefaultStr(),list.getRange()[0],list.getRange()[1]);
        }
        else if(list.getListType().equals("bool")) {
            this.DefaultStr=StringSpecificationOutput.specBool(list.getDefaultStr());
        }
    }

    @Override
    public String getString() {
        String res=privateRandom.RandomDouble(0,1)<Proportion?DefaultStr:innerCreater.getString();
        post(res);
        return res;
    }
}
