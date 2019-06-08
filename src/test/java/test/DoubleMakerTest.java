package test;

import Utils.privateRandom;
import xyz.calvinwilliams.okjson.OKJSON;

import java.io.*;
import java.nio.channels.FileChannel;
import java.util.*;

public class DoubleMakerTest {
    public static void main(String ar[])
    {
        Double d=47385974985974885745756376675598.65347676763765376;
        System.out.println(d);
        System.out.println(d.isInfinite());
        System.out.println(Double2String(d));
        System.out.println((privateRandom.RandomGaussian()%1));
    }

    private static String Double2String(Double d) {
        String s[] = d.toString().split("\\.");
        if (s[1].toString().indexOf("E") == -1)
            return s[0];

        String s1[] = s[1].split("E");
        StringBuilder res=new StringBuilder(s[0]);
        res.append(s1[0]);
        int length = Integer.valueOf(s1[1]);

        if(s1[0].length() < length) {
            Double lowercase = Math.abs(new Random().nextGaussian()) * Math.pow(10, s1[0].length());
            res.append(Double2String(lowercase));
        }

        return res.toString();
    }
}
