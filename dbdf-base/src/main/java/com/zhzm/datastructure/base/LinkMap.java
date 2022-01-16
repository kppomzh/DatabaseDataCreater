package com.zhzm.datastructure.base;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class LinkMap<K,V> {
    private final HashMap<K,V> map;
    private final LinkedList<V> list;

    public LinkMap(){
        map=new HashMap<>();
        list=new LinkedList<>();
    }

    public void put(K key,V value){
        map.put(key, value);
        list.addLast(value);
    }

    public V get(K key){
        return map.get(key);
    }

    public V getLast(){
        return list.getLast();
    }

    public int size(){
        return list.size();
    }

    public Iterator<V> listIterator(){
        return list.listIterator();
    }
}
