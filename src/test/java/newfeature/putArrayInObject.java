package newfeature;

import java.util.Collections;
import java.util.HashSet;

public class putArrayInObject {
    public static void main(String ar[]){
        String[] str=new String[]{"fdsafdasf","fdgfd"};
        Object o=str;
//        put(o.getClass());
        putSet((Object[])o);
//        putSet(str);
    }

    public static void put(Object o){
        System.out.println(o.getClass().getName());
    }

    private static void putSet(Object... o){
        HashSet set=new HashSet();
        Collections.addAll(set,o);
    }
}
