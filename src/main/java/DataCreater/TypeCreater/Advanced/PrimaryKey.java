package DataCreater.TypeCreater.Advanced;

import DataCreater.TypeCreater.baseTypeCreaterImpl;

import java.math.BigInteger;

public class PrimaryKey extends baseTypeCreaterImpl {
    private BigInteger startPrimary;

    public PrimaryKey(){
        this(BigInteger.ZERO);
    }

    public PrimaryKey(BigInteger start){
        startPrimary=start;
    }

    @Override
    public String getString(Object... option) {
        startPrimary=startPrimary.add(BigInteger.ONE);
        return startPrimary.toString();
    }
}
