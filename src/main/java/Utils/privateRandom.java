package Utils;

import jdk.jfr.Unsigned;

import java.math.BigInteger;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class privateRandom {
    private static ThreadLocalRandom rm;
    private static Lock lock;
    private static int num=0;
    private static long changenum=0;
    static {
        rm=ThreadLocalRandom.current();
        lock=new ReentrantLock();
    }

    public static void reSetRandom(){
        try {
            rm.setSeed(System.nanoTime());
        }catch(java.lang.UnsupportedOperationException e){
            changenum++;//"随机种子未重置。";
        }
    }

    /**
     * 获取指定区间内随机数值，取值范围是[start,end)
     * @param start 随机区间起始值
     * @param end 随机区间终止值
     * @return 双精度浮点
     */
    public static Double RandomDouble(double start, double end) {
        counter();
        Double minunum=end - start;

        if (minunum==0)
            return start;

        double Return = Math.abs(rm.nextDouble()*3);
        if (Return > end - start) {
            Return = Return % (end - start);
        }
        return Return + start;
    }

    public static boolean RandomBool() {
        return rm.nextBoolean();
    }

    public static int RandomInteger(int start,int end){
        counter();

        if (end<=start)
            return start;
        int Return = rm.nextInt(end - start);

        return Return + start;
    }

    /**
     * 获取指定区间内随机数值，取值范围是[start,end]
     * @param start 随机区间起始值
     * @param end 随机区间终止值
     * @return 大整数
     */
    public static BigInteger RandomBInteger(BigInteger start, BigInteger end){
        if (start.compareTo(end)>=0)
            return start;

        BigInteger sub=end.subtract(start);

        BigInteger res=new BigInteger(sub.bitLength(),rm);

        //当随机值大于start与end的差值，且差值大于0
        if(res.compareTo(sub)==1&&sub.compareTo(BigInteger.ZERO)==1){
            res=res.mod(sub);
        }

        return res.add(start);
    }

    /**
     * 定期更换随机数种子
     */
    private static void counter(){
        if(num>20000000&&lock.tryLock()){
            num=0;
            reSetRandom();
            lock.unlock();
        }
        num++;
    }
}
