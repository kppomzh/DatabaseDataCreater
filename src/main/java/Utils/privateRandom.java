package Utils;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class privateRandom {
    private static Random rm;
    static {
        rm=new Random(System.nanoTime());
    }

    public static void reSetRandom(){
        rm.setSeed(System.nanoTime());
    }

    /**
     * 获取指定区间内随机数值，取值范围是[start,end)
     * @param start 随机区间起始值
     * @param end 随机区间终止值
     * @return 双精度浮点
     */
    public static Double RandomDouble(double start, double end) {
        if (start == end)
            return start;

        double Return = Math.abs(rm.nextDouble());
        if (Return > end - start) {
            Return = Return % (end - start);
        }
        return Return + start;
    }

    public static boolean RandomBool() {
        return rm.nextBoolean();
    }

    public static int RandomInteger(int start,int end){
        if (start == end)
            return start;
        int Return = Math.abs(rm.nextInt()<<4);
        if (Return > end - start) {
            Return = Return % (end - start);
        }
        return Return + start;
    }

    public static double RandomGaussian(){
        return Math.abs(rm.nextGaussian());
    }
}
