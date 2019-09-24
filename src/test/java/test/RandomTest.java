package test;

import Utils.privateRandom;
import org.junit.Ignore;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;

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
        BigDecimal res=new BigDecimal(RandomBInteger(start,end));
//        res=res.add(BigDecimal.valueOf(privateRandom.RandomGaussian()));

        return res;
    }

//    @Ignore
    @Test
    public void getRandomTest(){
        RandomTest rt=new RandomTest();
        for (int i = 0; i < 100; i++) {
            System.out.println(rt.RandomBInteger("0","1000"));
        }

        System.out.println(rt.RandomBDecimal("100","1000"));
    }

    @Test
    public void largeNum(){
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            int r=privateRandom.RandomInteger(42,63);
            if(r<0)
                System.out.println(r);
        }
    }
}
