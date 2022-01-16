package com.zhzm.datacreater.typecreater.RegularCreater;

import com.zhzm.utils.privateRandom;

public class LengthExpression implements Regular {
    private int minlength,maxlength;

    public LengthExpression(int replaceNum){
        this(replaceNum,-1);
    }
    public LengthExpression(int minlength,int maxlength){
        this.minlength=minlength;
        this.maxlength=(maxlength==-1?(minlength+privateRandom.RandomInteger(10,20))*5:maxlength);
    }

    @Override
    public String getRealName() {
        return "LengthExpression";
    }

    @Override
    public void setLength(LengthExpression l) {
        this.maxlength=l.maxlength;
        this.minlength=l.minlength;
    }

    @Override
    public String getString() {
        return null;
    }

    @Override
    public int getRegularLength() {
        return 1;
    }

    public int getReplaceNum(){
        return privateRandom.RandomInteger(minlength,maxlength+1);
    }
}
