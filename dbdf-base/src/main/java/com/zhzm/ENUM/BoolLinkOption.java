package com.zhzm.ENUM;

import com.zhzm.antlr.createParser;

public enum BoolLinkOption {
    OR,AND;

    public static BoolLinkOption getOption(createParser.BoolLinkOptionContext ctx){
        if(ctx.OR()!=null)
            return OR;
        else
            return AND;
    }
}
