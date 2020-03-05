package DataCreater.TypeCreater.Advanced;

import DataCreater.TypeCreater.baseTypeCreaterImpl;

import java.math.BigInteger;

public class PrimaryKey extends baseTypeCreaterImpl {
    private BigInteger startPrimary=BigInteger.ZERO;

    @Override
    public String getString(Object... option) {
        startPrimary=startPrimary.add(BigInteger.ONE);
        return startPrimary.toString();
    }
}
