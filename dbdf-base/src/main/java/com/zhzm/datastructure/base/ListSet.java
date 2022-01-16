package com.zhzm.datastructure.base;

import com.facebook.presto.jdbc.internal.guava.collect.Lists;
import com.facebook.presto.jdbc.internal.guava.collect.Sets;

import java.util.*;
import java.util.function.UnaryOperator;

public class ListSet<E> implements Set<E>, List<E> {
    private final List<E> toList=new ArrayList<>();
    private final Set<E> toSet=new HashSet<>();

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public E get(int index) {
        return toList.get(index);
    }

    @Override
    public E set(int index, E element) {
        if(toSet.contains(element))
            return null;
        else {
            E e=toList.get(index);
            toSet.remove(e);
            toList.set(index, element);
            return e;
        }
    }

    @Override
    public void add(int index, E element) {
        if (!toSet.contains(element)) {
            toSet.add(element);
            toList.add(index,element);
        }
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return toList.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return toList.lastIndexOf(o);
    }

    @Override
    public ListIterator<E> listIterator() {
        return listIterator(0);
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return toList.listIterator(index);
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public int size() {
        return toSet.size();
    }

    @Override
    public boolean isEmpty() {
        return toSet.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return toSet.contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return listIterator();
    }

    @Override
    public Object[] toArray() {
        return toArray(new Object[0]);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return toList.toArray(a);
    }

    @Override
    public boolean add(E e) {
        if(toSet.contains(e))
            return false;
        else{
            toSet.add(e);
            toList.add(e);
            return true;
        }
    }

    @Override
    public boolean remove(Object o) {
        if(toSet.contains(o)){
            toSet.remove(o);
            toList.remove(o);
            return true;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return toSet.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        HashSet<Object> temp= Sets.newHashSet(c.toArray(new Object[0]));
        temp.retainAll(toSet);
        if(temp.size()==0)
            return false;
        else{
            toSet.addAll((Collection<? extends E>) temp);
            toList.addAll((Collection<? extends E>) temp);
            return true;
        }
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return toSet.retainAll(c);
    }

    @Override
    public void replaceAll(UnaryOperator<E> operator) {
        List.super.replaceAll(operator);
    }

    @Override
    public void sort(Comparator<? super E> c) {
        List.super.sort(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        toSet.removeAll(c);
        toList.removeAll(c);
        return true;
    }

    @Override
    public void clear() {
        toSet.clear();
        toList.clear();
    }

    @Override
    public Spliterator<E> spliterator() {
        return Set.super.spliterator();
    }
}
