package Utils;

import java.math.BigInteger;
import java.util.Random;

public class privateRandom {
    private final static Random rm= new Random();
    private final static Integer[] primelist={7,3,2,5};//4

    public static Double RandomNumber(double start,double end)
    {
        double Return=Math.abs(rm.nextDouble());

        if(end==Integer.MAX_VALUE) end--;
        if(Return<end-start&&Return*7>0)
            Return=Return*primelist[Math.abs(rm.nextInt()) % 4];
        while(Return>end-start) {
            Return = Return % (end - start + 1);
            break;
        }
        return Return+start;
    }
    public static boolean RandomBool()
    {
        return rm.nextBoolean();
    }
    public static BigInteger RandomBigInt(double start, double end)
    {
        BigInteger Return=new BigInteger(String.valueOf(rm.nextDouble()));
        while(Return.compareTo(new BigInteger(String.valueOf(end-start)))==-1)
        {
            Return.multiply(new BigInteger(String.valueOf(primelist[Math.abs(rm.nextInt())%8])));
        }
        return Return.remainder(new BigInteger(String.valueOf(end-start+1))).add(new BigInteger(String.valueOf(start)));
    }
}
