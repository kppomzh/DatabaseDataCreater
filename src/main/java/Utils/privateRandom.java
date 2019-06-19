package Utils;

import java.math.BigDecimal;
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

        if (start == end)
            return start;
        int Return = Math.abs(rm.nextInt()<<4);
        if (Return > end - start) {
            Return = Return % (end - start);
        }
        return Return + start;
    }

    public static BigInteger RandomBInteger(BigInteger start, BigInteger end){
        BigInteger sub=end.subtract(start).abs();

        if (start.equals(end))
            return start;
        BigInteger res=new BigInteger(sub.bitLength()+1,rm);

        if(res.compareTo(sub)==1){
            res=res.mod(sub);
        }

        return res.add(start);
    }

    private static void counter(){
        if(num>20000000&&lock.tryLock()){
            num=0;
            reSetRandom();
            lock.unlock();
        }
        num++;
    }
}
