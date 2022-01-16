package com.zhzm.datacreater.table.index;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ForeignKey extends BaseIndex {
    private String foreignerTable,foreignerList;
    private List<String> contents;
    private Lock lock;
    public ForeignKey(String listname) {
        super(listname);
        contents=new ArrayList<>();
        lock = new ReentrantLock();
    }

    @Override
    public int addLine(String... content) {
        lock.lock();
        contents.add(content[0]);
        lock.unlock();
        return -1;
    }

    public String getForeignerTable() {
        return foreignerTable;
    }

    public void setForeignerTable(String foreignerTable) {
        this.foreignerTable = foreignerTable;
    }

    public String getForeignerList() {
        return foreignerList;
    }

    public void setForeignerList(String foreignerList) {
        this.foreignerList = foreignerList;
    }

    public List<String> getContents(){return contents;}
}
