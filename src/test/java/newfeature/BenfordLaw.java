package newfeature;

import DataCreater.TypeCreater.numberTypeCreater;
import Utils.privateRandom;
import org.junit.Test;

import java.util.HashMap;

public class BenfordLaw {
    static double countNum=100000000d;
    static HashMap<Character,Double> resProb;
    {
        resProb=new HashMap<>();
        resProb.put('1',.301);
        resProb.put('2',.176);
        resProb.put('3',.125);
        resProb.put('4',.097);
        resProb.put('5',.079);
        resProb.put('6',.067);
        resProb.put('7',.058);
        resProb.put('8',.051);
        resProb.put('9',.046);
    }

    @Test
    public void statisticsNormalInteger(){
        HashMap<Character,Double> count=getCount();

        for(double i=0;i<countNum;i++){
            String s=privateRandom.RandomInteger(0,1000000000).toString();
            count.put(s.charAt(0),count.get(s.charAt(0))+1);
        }

        printVariance(count);
    }

    @Test
    public void statisticsNumberType(){
        HashMap<Character,Double> count=getCount();
        numberTypeCreater n=new numberTypeCreater(10,0,new String[]{null,null},false);

        for(int i=0;i<countNum;i++){
            String s=n.getString();
            count.put(s.charAt(0),count.get(s.charAt(0))+1);
        }

        printVariance(count);
    }

    private HashMap<Character,Double> getCount(){
        HashMap<Character,Double> count=new HashMap<>();
        for(int i=49;i<58;i++){
            count.put((char)i,0d);
        }
        return count;
    }

    private void printVariance(HashMap<Character,Double> count){
        double sigma=0d;
        for(int i=49;i<58;i++){
            double realProb=count.get(Character.valueOf((char)i))/countNum;
            sigma=sigma+Math.pow(realProb,2);
            System.out.println("Diff for "+(char)i+" is:"+(realProb-resProb.get((char)i)));
        }
        System.out.println("Variance:"+sigma);
    }
}
