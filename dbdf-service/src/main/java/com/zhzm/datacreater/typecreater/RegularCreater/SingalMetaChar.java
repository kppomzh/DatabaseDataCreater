package com.zhzm.datacreater.typecreater.RegularCreater;

import com.zhzm.datacreater.typecreater.baseTypeCreaterImpl;

public class SingalMetaChar implements Regular {
    private char MetaChar;
    private LengthExpression length;

    public SingalMetaChar(char metaChar){
        MetaChar=metaChar;
        try {
            length=new LengthExpression(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getRealName() {
        return "SingalMetaChar";
    }

    @Override
    public void setLength(LengthExpression l) {
        length=l;
    }

    @Override
    public String getString() {
        int Stringlength=length.getReplaceNum();
        StringBuilder sb=new StringBuilder();
        for(int loop = 0; loop < Stringlength; loop++) {
            sb.append(baseTypeCreaterImpl.
                    getArbitraryCharacter(1,MetaChar));
        }
        return sb.toString();
    }

    @Override
    public int getRegularLength() {
        return 1;
    }
}
