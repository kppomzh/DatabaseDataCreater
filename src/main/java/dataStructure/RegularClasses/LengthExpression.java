package dataStructure.RegularClasses;

import Utils.privateRandom;

public class LengthExpression implements Regular {
    private Integer minlength,maxlength=null;

    public LengthExpression(Integer replaceNum) throws Exception {
        if(replaceNum<0)
            throw new Exception("正则表达式的元字符最小长度不能小于0。");
        minlength=replaceNum;
    }
    public LengthExpression(Integer minlength,Integer maxlength) throws Exception {
        if(minlength<0)
            throw new Exception("正则表达式的元字符最小长度不能小于0。");
        this.minlength=minlength;
        this.maxlength=(maxlength==null?(minlength+1)*5:maxlength);
        if(this.maxlength>=0&&this.minlength>this.maxlength){
            throw new Exception("正则表达式的元字符最小长度不能大于最大长度。");
        }
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

    public int getReplaceNum(){
        return (maxlength==null?minlength: privateRandom.RandomNumber(minlength,maxlength+1).intValue());
    }
}
