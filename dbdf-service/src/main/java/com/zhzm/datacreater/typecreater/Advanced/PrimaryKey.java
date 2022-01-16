package com.zhzm.datacreater.typecreater.Advanced;

import com.zhzm.datacreater.typecreater.baseTypeCreaterImpl;

import java.math.BigInteger;

public class PrimaryKey extends baseTypeCreaterImpl {
    private BigInteger startPrimary;
    private long primaryLength;

    public PrimaryKey(long length){
        this(length,BigInteger.ZERO);
    }

    public PrimaryKey(long length, BigInteger start){
        super();
        startPrimary=start;
        primaryLength=length==0L?Long.MAX_VALUE:length;
    }

    @Override
    public String getString() {
        startPrimary=startPrimary.add(BigInteger.ONE);
        String res=startPrimary.toString();
        if(res.length()>primaryLength){
            throw new RuntimeException("主键超长");
        }
        post(res);
        return res;
    }
}
