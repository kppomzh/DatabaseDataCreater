package com.zhzm.datacreater.typecreater;

import com.zhzm.utils.privateRandom;

import java.math.BigDecimal;
import java.math.BigInteger;

public class numberTypeCreater extends baseTypeCreaterImpl {
    private BigInteger intMax,intMin;
    private BigDecimal decMax,decMin;
    private int decLength;
    private boolean canbeNagetive;
    private boolean hasDec=false;

    public numberTypeCreater(int mainRange, int decRange, String[] Numberarea, boolean nagetive){
        super();
        canbeNagetive=nagetive;

        intMax =BigInteger.valueOf(Double.valueOf(Math.pow(10,mainRange-decRange)).longValue()).subtract(BigInteger.ONE);
        intMin=BigInteger.ZERO;
        if(decRange>0){
            hasDec=true;
            decLength=2+decRange;
            decMax=BigDecimal.ZERO;
            decMin=BigDecimal.ZERO;
        }
        else
            decLength=0;


        if(Numberarea[0]!=null){
            String[] areaMax=Numberarea[1].split("\\."),areaMin=Numberarea[0].split("\\.");
            if(areaMax.length==1){
                decMax=BigDecimal.ZERO;
                decMin=BigDecimal.ZERO;
            }
            else{
                decMax=new BigDecimal("0."+areaMax[1]);
                decMin=new BigDecimal("0."+areaMin[1]);
            }

            BigInteger intAreaMax=new BigInteger(areaMax[0]),intAreaMin=new BigInteger(areaMin[0]);

            canbeNagetive|=intAreaMin.compareTo(intMin)<0;
            intMin=intAreaMin;

            intMax=intAreaMax.compareTo(intMax)<0?intAreaMax:intMax;
        }
    }

    private String getNumber(){
        StringBuilder res=new StringBuilder();
        BigInteger intres;
        BigDecimal decres = null;

        if(canbeNagetive&& privateRandom.RandomBool()){
            res.append('-');
        }

        intres=privateRandom.RandomBInteger(intMin, intMax);

        if(hasDec){
            decres=privateRandom.RandomBDecimal();
            if(intres.compareTo(intMax)==0){
                if(decres.compareTo(decMax) > 0){
                    intres=intres.subtract(BigInteger.ONE);
                }
            }
            else if(intres.compareTo(intMin)==0){
                if(decres.compareTo(decMin) < 0){
                    intres=intres.add(BigInteger.ONE);
                }
            }
        }

        res.append(intres.toString());
        if(hasDec) {
            res.append('.');
            res.append(decres.toPlainString(), 2, decLength);
        }
        return res.toString();
    }

    @Override
    public String getString() {
        String res=getNumber();
        post(res);
        return getNumber();
    }
}
