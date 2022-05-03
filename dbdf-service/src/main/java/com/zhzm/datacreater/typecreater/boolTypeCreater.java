package com.zhzm.datacreater.typecreater;

import com.zhzm.utils.privateRandom;

public class boolTypeCreater extends baseTypeCreaterImpl {
    @Override
    public String getString() {
        return String.valueOf(privateRandom.RandomBool());
    }
}
