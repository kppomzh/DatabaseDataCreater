package com.zhzm.datacreater.typecreater.Advanced;


import com.zhzm.datacreater.typecreater.baseTypeCreaterImpl;
import com.zhzm.datastructure.table.ListStructure;
import com.zhzm.utils.BaseEnvironment;
import com.zhzm.utils.StringSpecificationOutput;
import com.zhzm.utils.privateRandom;

public class InlineTypeCreater extends baseTypeCreaterImpl {
    private String[] inlineArray;

    public InlineTypeCreater(ListStructure list){
        super(list.isRely());
        inlineArray=list.getInlineObjects();

        if(list.getListType().equals("string")){
            for (int loop = 0; loop < inlineArray.length; loop++) {
                inlineArray[loop]='\''+StringSpecificationOutput.specString(inlineArray[loop],list.getRange()[0])+'\'';
            }
        }
        else if(list.getListType().equals("number")){
            for (int loop = 0; loop < inlineArray.length; loop++) {
                StringSpecificationOutput.specNumber(inlineArray[loop],list.getRange()[0],list.getRange()[1]);
            }
        }
        else if(list.getListType().equals("bool")) {
            for (int loop = 0; loop < inlineArray.length; loop++) {
                StringSpecificationOutput.specBool(inlineArray[loop]);
            }
        }
        else if(list.getListType().equals("date")){
            if("sql".equals(BaseEnvironment.getEnvironment("toDB")) || "jdbc".equals(BaseEnvironment.getEnvironment("toDB"))){
                for (int loop = 0; loop < inlineArray.length; loop++) {
                    inlineArray[loop] = StringSpecificationOutput.specDate(inlineArray[loop]);
                }
            }
            else{
                for (int loop = 0; loop < inlineArray.length; loop++) {
                    inlineArray[loop]='\''+inlineArray[loop]+'\'';
                }
            }
        }
    }

    @Override
    public String getString(Object... option) {
        return inlineArray[privateRandom.RandomInteger(0,inlineArray.length)];
    }
}
