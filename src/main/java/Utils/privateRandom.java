package Utils;

import java.math.BigInteger;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class privateRandom {
    private static ThreadLocalRandom rm;
    private static Lock lock;
    private static int num=0;
    static {
        rm=ThreadLocalRandom.current();
        lock=new ReentrantLock();
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
        counter();
        Double minunum=end - start;

        if (minunum==0)
            return start;

        double Return = Math.abs(rm.nextDouble()*Math.pow(10,minunum.toString().length()-3));
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

    public static double RandomGaussian(){
        return Math.abs(rm.nextGaussian());
    }

//    public static BigInteger RandomBInteger(String start,String end){
//        BigInteger startInteger=new BigInteger(start),endInteger=new BigInteger(end);
//
//        BigInteger Return=new BigInteger(2,rm);
//    }

    private static void counter(){
        if(num>20000000&&lock.tryLock()){
            num=0;
            reSetRandom();
            lock.unlock();
        }
        num++;
    }
}
