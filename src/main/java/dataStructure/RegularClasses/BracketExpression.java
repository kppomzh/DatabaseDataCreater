package dataStructure.RegularClasses;

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
    public String getGeneratedString() {
        int Stringlength=length.getReplaceNum();
        char[] str=new char[Stringlength];
        for(int loop=0;loop<Stringlength;loop++){
            str[loop]=markFiled.charAt(privateRandom.RandomNumber(
                    0,markFiled.length()).intValue());
        }
        return new String(str);
    }

    @Override
    public int getRegularLength() {
        return markFiled.length();
    }
}
