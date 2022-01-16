package com.zhzm.datacreater.typecreater.Advanced;

import com.zhzm.datacreater.typecreater.baseTypeCreater;
import com.zhzm.datacreater.typecreater.baseTypeCreaterImpl;

public class RelyTypeCreater extends baseTypeCreaterImpl {
    private baseTypeCreater creater;
    public RelyTypeCreater(baseTypeCreater creater){
        isRely();
        this.creater=creater;
    }

    @Override
    public String getString() {
        String content= creater.getString();
        super.relyContent.add(content);
        return content;
    }
}
