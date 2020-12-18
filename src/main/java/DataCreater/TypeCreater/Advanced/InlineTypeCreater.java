package DataCreater.TypeCreater.Advanced;

import DataCreater.TypeCreater.baseTypeCreater;
import Utils.StringSpecificationOutput;
import Utils.privateRandom;
import dataStructure.ListStructure;
import dataStructure.RuntimeEnvironment;

public class InlineTypeCreater implements baseTypeCreater {
    private String[] inlineArray;

    public InlineTypeCreater(ListStructure list, RuntimeEnvironment env){
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
            if("sql".equals(env.getToDB()) || "jdbc".equals(env.getToDB())){
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
