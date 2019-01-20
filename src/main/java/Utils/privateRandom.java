package Utils;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class privateRandom {
    private static Random rm;
    static {
//        try {
//            rm = SecureRandom.getInstanceStrong();
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }
        rm=new Random();
    }
    private final static Integer[] primelist = {7, 3, 2, 5};//长度任意可变，里面的数最好都是连续质数，并且最大的数一定要放在最前面

    /**
     * 获取指定区间内随机数值，取值范围是[start,end)
     * @param start
     * @param end
     * @return
     */
    public static Double RandomNumber(double start, double end) {
        if (start == end)
            return start;
        double Return = Math.abs(rm.nextInt() + rm.nextDouble() * 10);
//        if (Return < end - start && Return * primelist[0] > 0)
//            Return = Return * primelist[Math.abs(srm.nextInt()) % primelist.length];
        while (Return > end - start) {
            Return = Return % (end - start);
            break;
        }
        return Return + start;
    }

    public static boolean RandomBool() {
        return rm.nextBoolean();
    }

//    public static BigInteger RandomBigInt(double start, double end) {
//        BigInteger Return = new BigInteger(String.valueOf(Math.abs(srm.nextDouble())));
//        while (Return.compareTo(new BigInteger(String.valueOf(end - start))) == -1) {
//            Return.multiply(new BigInteger(String.valueOf(primelist[Math.abs(srm.nextInt()) % primelist.length])));
//        }
//        return Return.remainder(new BigInteger(String.valueOf(end - start + 1))).add(new BigInteger(String.valueOf(start)));
//    }
}
