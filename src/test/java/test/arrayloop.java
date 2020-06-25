package test;

import Utils.LoopLinked;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.LinkedList;

public class arrayloop {
    private static int loopCount=10000000;
    public static void main(String ar[]){
        ArrayDeque<String> a1=new ArrayDeque<>();
        LinkedList<String> a2=new LinkedList<>();
        String[] a3=new String[10];
        LoopLinked<String> a4=new LoopLinked<>();

        for (int i = 0; i < 10; i++) {
            String add=String.valueOf(i);
            a1.add(add);
            a2.add(add);
            a3[i]=add;
            a4.addContent(add);
        }

        arrayloop a=new arrayloop();
        a.loopA1(a1);
        a.loopA2(a2);
        a.loopA3(a3);
        a.loopA4(a4);
    }

    private void loopA1(ArrayDeque<String> a1){
        long time=System.nanoTime();
        for (int i = 0; i < loopCount; i++) {
            Iterator<String> iterator=a1.iterator();
            while (iterator.hasNext()){
                Object o=iterator.next();
            }
        }
        System.out.println((System.nanoTime()-time)/1000);
    }
    private void loopA2(LinkedList<String> a2){
        long time=System.nanoTime();
        for (int i = 0; i < loopCount; i++) {
//            Iterator<String> iterator=a2.iterator();
//            while (iterator.hasNext()){
//                Object o=iterator.next();
//            }
            String[] array= a2.toArray(new String[0]);
            for (int j = 0; j < array.length; j++) {
                Object o=array[j];
            }
        }
        System.out.println((System.nanoTime()-time)/1000);

    }
    private void loopA3(String[] a3){
        long time=System.nanoTime();
        for (int i = 0; i < loopCount; i++) {
            for (int j = 0; j < a3.length; j++) {
                Object o=a3[j];
            }
        }
        System.out.println((System.nanoTime()-time)/1000);

    }
    private void loopA4(LoopLinked<String> a4){
        long time=System.nanoTime();
        for (int i = 0; i < loopCount; i++) {
            do {
                Object o=a4.getNextContent();
            }while (a4.hasNext());
        }
        System.out.println((System.nanoTime()-time)/1000);

    }
}
