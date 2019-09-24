package dataStructure.RegularClasses;

import Utils.privateRandom;

public class LengthExpression implements Regular {
    private Integer minlength,maxlength=null;

    public LengthExpression(Integer replaceNum){
        minlength=replaceNum;
    }
    public LengthExpression(Integer minlength,Integer maxlength){
        this.minlength=minlength;
        this.maxlength=(maxlength==null?(minlength+1)*5:maxlength);
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
    public String getGeneratedString() {
        return null;
    }

    @Override
    public int getRegularLength() {
        return 1;
    }

    public int getReplaceNum(){
        return (maxlength==null?minlength: privateRandom.RandomInteger(minlength,maxlength+1));
    }
}
