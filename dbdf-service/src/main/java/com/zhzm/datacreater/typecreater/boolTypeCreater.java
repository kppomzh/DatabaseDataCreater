package com.zhzm.datacreater.typecreater;

import com.zhzm.utils.privateRandom;

public class boolTypeCreater extends baseTypeCreaterImpl {
    public boolTypeCreater() {
        super(false);
    }

    @Override
    public String getString() {
        return String.valueOf(privateRandom.RandomBool());
    }
}
