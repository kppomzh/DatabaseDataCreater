package test;

import Utils.privateRandom;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomTest {

    public static BigInteger RandomBInteger(String startStr, String endStr){
        BigInteger start=new BigInteger(startStr),
                end=new BigInteger(endStr);
        BigInteger sub=end.subtract(start).abs();

        if (start.equals(end))
            return start;
        BigInteger res=new BigInteger(sub.bitLength()+1,new Random());

        if(res.compareTo(sub)==1){
            res=res.mod(sub);
        }

        return res.add(start);
    }
    public static BigDecimal RandomBDecimal(String start, String end){
        return new BigDecimal(RandomBInteger(start,end));
    }

//    @Ignore
    @Test
    public void getRandomTest(){
        RandomTest rt=new RandomTest();
        for (int i = 0; i < 100; i++) {
            System.out.println(RandomBInteger("0","1000"));
        }

        System.out.println(RandomBDecimal("100","1000"));
    }

    @Test
    public void largeNum(){
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            int r=privateRandom.RandomInteger(42,63);
            if(r<0)
                System.out.println(r);
        }
    }

    @Test
    public void difRandomTime(){
        Random rm1= ThreadLocalRandom.current();
        Random rm2=new Random();

        long time;
        time=System.nanoTime();
        for(int loop=0;loop<10000000;loop++){
            rm1.nextInt();
        }
        System.out.println((System.nanoTime()-time)/1000D);

        time=System.nanoTime();
        for(int loop=0;loop<10000000;loop++){
            rm2.nextInt();
        }
        System.out.println((System.nanoTime()-time)/1000D);

        time=System.nanoTime();
        for(int loop=0;loop<10000000;loop++){
            Math.random();
        }
        System.out.println((System.nanoTime()-time)/1000D);
    }

    @Test
    public void ad(){
        int i=3,a=i;
        System.out.println(i^((i>>1)<<1));
        System.out.println(i);
    }
}
