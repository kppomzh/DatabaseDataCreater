package com.zhzm.datastructure.base;

//如果要使用循环遍历，请用do……while循环遍历。
public class LoopLinked <T> {
    node<T> start,end,now;
    private int size;

    public void addContent(T content){
        node<T> newEnd=new node<>();
        newEnd.setContent(content);
        if(start==null){
            newEnd.setFirst();
            start=newEnd;
            end=newEnd;
            now=newEnd;
            newEnd.setNext(newEnd);
        }
        else{
            end.setNext(newEnd);
            newEnd.setNext(start);
            end=newEnd;
            now=newEnd;
        }
        size++;
    }

    public boolean hasNext(){
        return !now.isFirst();
    }

    public T getNextContent(){
        now=now.getNext();
        return now.getContent();
    }

    public int size(){
        return size;
    }
}

class node <T>{
    private boolean isFirst=false;
    private node next;
    private T content;

    void setNext(node n){
        next=n;
    }
    void setFirst(){
        isFirst=true;
    }

    boolean isFirst(){
        return isFirst;
    }
    node getNext(){
        return next;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }
}
