package Utils;

import java.util.Random;

public class privateRandom {
    private static Random rm;
    static {
        rm=new Random();
    }
    private final static Integer[] primelist = {19, 7, 11, 5};//长度任意可变，里面的数最好都是连续质数，并且最大的数一定要放在最前面

    /**
     * 获取指定区间内随机数值，取值范围是[start,end)
     * @param start 随机区间起始值
     * @param end 随机区间终止值
     * @return 双精度浮点
     */
    public static Double RandomNumber(double start, double end) {
        if (start == end)
            return start;
        double Return = Math.abs(rm.nextInt() + rm.nextDouble() * 10);
        if (Return > end - start) {
            Return = Return % (end - start);
        }
        return Return + start;
    }

    public static boolean RandomBool() {
        return rm.nextBoolean();
    }
}
