package test;

import com.alibaba.fastjson.JSON;
import xyz.calvinwilliams.okjson.OKJSON;

import java.io.*;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class mergeFiles {
    public static void main(String ar[])
    {
        Map<String,Object> map=new HashMap();

        map.put("aaa","bbb");
        map.put("bbb",123);

        String s=OKJSON.objectToString(map,4);
        System.out.println(s);
        s=OKJSON.objectToString(map,6);
        System.out.println(s);
        s= JSON.toJSONString(map);
        System.out.println(s);
    }


}
