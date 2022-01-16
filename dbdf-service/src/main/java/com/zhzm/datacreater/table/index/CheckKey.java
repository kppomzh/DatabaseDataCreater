package com.zhzm.datacreater.table.index;

import com.zhzm.ENUM.BoolLinkOption;

import java.util.*;

public class CheckKey extends BaseIndex {
    private List<checkFunction> checkFunctionList;
    private List<BoolLinkOption> functionLinkOptions;

    public CheckKey(String... listnames){
        super(listnames);
        checkFunctionList=new ArrayList<>();
        functionLinkOptions=new ArrayList<>();
    }

    @Override
    public int addLine(String... content) {
        boolean canAdd=checkFunctionList.get(0).addContent(content[0])
                ,canOr=true;

        if(functionLinkOptions.get(1)==BoolLinkOption.AND && !canAdd)
            return 0;
        else
            canOr=false;

        for(var i=1;i<content.length;i++){
            canAdd = checkFunctionList.get(i).addContent(content);

            if(!canAdd) {
                if(canOr && functionLinkOptions.get(i)==BoolLinkOption.OR){
                    canOr=false;
                }
                else {
                    return i;
                }
            }
            else
                canOr=true;
        }
        return -1;
    }

    public void addCheckOptions(String listname,String checkOption,Object[] options){
        checkFunction function;
        switch (checkOption){
            case "in":
                function=new checkIn();
                function.setCheckOptions(options);
                break;
            case ">":
                function=new checkLargeComparsion();
                function.setCheckOptions(options);
                break;
            case ">=":
                function=new checkLargeEuqalComparsion();
                function.setCheckOptions(options);
                break;
            case "=": case"==":
                function=new checkEqualComparsion();
                function.setCheckOptions(options);
                break;
            case "<=":
                function=new checkLessEuqalComparsion();
                function.setCheckOptions(options);
                break;
            case "is null":
                function=new checkIsNull();
                break;
            default:
                function=new checkNotNull();
        }
//        functionLinkOptions.add(listname);
        checkFunctionList.add(function);
    }

    public void setFunctionLinkOptions(List<BoolLinkOption> functionLinkOptions) {
        this.functionLinkOptions = functionLinkOptions;
    }
    public void addFunctionLinkOptions(BoolLinkOption functionLinkOption) {
        this.functionLinkOptions.add(functionLinkOption);
    }
}

interface checkFunction{
    void setCheckOptions(Object option);
    boolean addContent(Object content);
}

class checkIn implements checkFunction {
    private final HashSet<Object> checkOptions;

    public checkIn(){
        checkOptions=new HashSet<>();
    }
    @Override
    public void setCheckOptions(Object options){
        Object[] optionArray=(Object[])options;
        Collections.addAll(checkOptions,optionArray);
    }
    @Override
    public boolean addContent(Object content) {
        return checkOptions.contains(content);
    }
}

abstract class checkE implements checkFunction{
    protected Object checkOption;
    @Override
    public void setCheckOptions(Object options){
        checkOption=options;
    }
}

class checkEqualComparsion extends checkE {
    @Override
    public boolean addContent(Object content) {
        return checkOption.equals(content);
    }
}

class checkLargeComparsion extends checkE {
    @Override
    public boolean addContent(Object content) {
        return content.hashCode()>checkOption.hashCode();
    }
}

class checkLessComparsion extends checkE {
    @Override
    public boolean addContent(Object content) {
        return content.hashCode()<checkOption.hashCode();
    }
}

class checkLargeEuqalComparsion extends checkE {
    @Override
    public boolean addContent(Object content) {
        return content.hashCode()>=checkOption.hashCode();
    }
}

class checkLessEuqalComparsion extends checkE {
    @Override
    public boolean addContent(Object content) {
        return content.hashCode()<=checkOption.hashCode();
    }
}

class checkIsNull extends checkE {
    @Override
    public boolean addContent(Object content) {
        return content==null;
    }
}

class checkNotNull extends checkE {
    @Override
    public boolean addContent(Object content) {
        return content!=null;
    }
}