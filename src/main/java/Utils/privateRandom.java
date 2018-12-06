package Utils;

import java.math.BigInteger;
import java.security.SecureRandom;

public class privateRandom {
    private final static SecureRandom srm=new SecureRandom();
    private final static Integer[] primelist = {7, 3, 2, 5};//长度任意可变，里面的数最好都是连续质数，并且最大的数一定要放在最前面

    public static Double RandomNumber(double start, double end) {
        if (start == end)
            return start;
        double Return = Math.abs(srm.nextInt() + srm.nextDouble() * 10);
        if (Return < end - start && Return * primelist[0] > 0)
            Return = Return * primelist[Math.abs(srm.nextInt()) % primelist.length];
        while (Return > end - start) {
            Return = Return % (end - start + 1);
            break;
        }
        return Return + start;
    }

    public static boolean RandomBool() {
        return srm.nextBoolean();
    }

    public static BigInteger RandomBigInt(double start, double end) {
        BigInteger Return = new BigInteger(String.valueOf(Math.abs(srm.nextDouble())));
        while (Return.compareTo(new BigInteger(String.valueOf(end - start))) == -1) {
            Return.multiply(new BigInteger(String.valueOf(primelist[Math.abs(srm.nextInt()) % primelist.length])));
        }
        return Return.remainder(new BigInteger(String.valueOf(end - start + 1))).add(new BigInteger(String.valueOf(start)));
    }
}
