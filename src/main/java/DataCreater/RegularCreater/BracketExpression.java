package DataCreater.RegularCreater;

import Utils.privateRandom;

public class BracketExpression implements Regular {
    private StringBuilder markFiled = new StringBuilder();
    private LengthExpression length;

    public BracketExpression(){
        try {
            length=new LengthExpression(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addFiled(char start,char end){
        for(char loop=start;loop<=end;loop++)
            addFiled(loop);
    }

    public void addFiled(char c){
        markFiled.append(c);
    }

    @Override
    public String getRealName() {
        return "BracketExpression";
    }

    @Override
    public void setLength(LengthExpression l) {
        length=l;
    }

    @Override
    public StringBuilder getString() {
        int Stringlength=length.getReplaceNum();
        StringBuilder str=new StringBuilder(Stringlength);
        for(int loop=0;loop<Stringlength;loop++){
            str.append(markFiled.charAt(privateRandom.RandomInteger(
                    0,markFiled.length())));
        }
        return str;
    }

    @Override
    public int getRegularLength() {
        return markFiled.length();
    }
}
