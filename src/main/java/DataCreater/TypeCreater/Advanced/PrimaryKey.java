package DataCreater.TypeCreater.Advanced;

import DataCreater.TypeCreater.baseTypeCreaterImpl;
import dataStructure.ListStructure;

import java.math.BigInteger;

public class PrimaryKey extends baseTypeCreaterImpl {
    private BigInteger startPrimary;
    private int primaryLength;

    public PrimaryKey(ListStructure list){
        this(list,BigInteger.ZERO);
    }

    public PrimaryKey(ListStructure list,BigInteger start){
        startPrimary=start;
        primaryLength=list.getRange()[0]==0?Integer.MAX_VALUE:list.getRange()[0];
    }

    @Override
    public String getString(Object... option) {
        startPrimary=startPrimary.add(BigInteger.ONE);
        String res=startPrimary.toString();
        if(res.length()>primaryLength){
            throw new RuntimeException("主键超长");
        }
        return res;
    }
}
