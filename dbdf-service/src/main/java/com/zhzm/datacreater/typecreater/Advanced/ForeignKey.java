package com.zhzm.datacreater.typecreater.Advanced;

import com.zhzm.datacreater.typecreater.baseTypeCreaterImpl;
import com.zhzm.datastructure.base.ListSet;
import com.zhzm.utils.privateRandom;

public class ForeignKey extends baseTypeCreaterImpl {

    private ListSet<String> foreignContent;

    public ForeignKey(baseTypeCreaterImpl creater){
        foreignContent=creater.getRely();
    }

    @Override
    public String getString() {
        return foreignContent.get(privateRandom.RandomInteger(0,relyContent.size()));
    }
}
