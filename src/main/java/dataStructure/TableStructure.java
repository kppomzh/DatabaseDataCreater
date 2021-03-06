package dataStructure;

import DataCreater.TypeCreater.Advanced.PrimaryKey;
import Exception.DataException.TableStrucDataException;
import Utils.privateRandom;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TableStructure implements Cloneable {
    private int MaxListRange = 0;//本表中的最大字段长度
    private String tbname;//表名
    private StringBuilder listnamessb;//需要填充的字段名总和
    private List<ListStructure> listStructureList,numberStructureList,stringStructureList;
    private int readnum = -1;
    private boolean unmake = false;//是否存在不需要填充的字段
    private boolean hasPrimary = false;
    private ListStructure primaryList;
    private BigInteger startPrimary,primaryInterval;
    private long size;
    private List<String> foreignRely;

    public TableStructure() {
        listnamessb = new StringBuilder();
        listStructureList = new ArrayList<>();
        numberStructureList=new ArrayList<>();
        stringStructureList=new ArrayList<>();
        foreignRely=new LinkedList<>();
        startPrimary=BigInteger.ZERO;
    }

    public void addList(ListStructure ls) throws TableStrucDataException {
        if(hasPrimary&&ls.isPrimary()){
            throw new TableStrucDataException("同一个表中不允许有两个主键");
        }
        else{
            if (ls.isPrimary()) {
                hasPrimary=true;
                primaryList=ls;
            }
        }

        if(ls.isForeign()){
            foreignRely.add(ls.getForeignTable());
        }

        if(ls.isUnmake()){
            unmake=true;
        } else{
            if (listnamessb.length() != 0)
                listnamessb.append(',');

            listnamessb.append(ls.getListname());
        }

        if(ls.getListType().equals("number")){
            numberStructureList.add(ls);
        }
        else if(ls.getListType().equals("string")){
            stringStructureList.add(ls);
        }
        listStructureList.add(ls);
    }

    public boolean hasNext() {
        if (readnum >= listStructureList.size() - 1) {
            readnum = -1;
            return false;
        }
        return true;
    }

    //取字段结构
    public ListStructure getNextStruc() {
        readnum++;
        return listStructureList.get(readnum);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        TableStructure newT = new TableStructure();
        if(hasPrimary) {
            this.startPrimary = this.startPrimary.add(this.primaryInterval);
            newT.startPrimary = this.startPrimary;
        }

        for (int loop = 0; loop < this.listStructureList.size(); loop++) {
            if(this.listStructureList.get(loop)==this.primaryList){
                ListStructure copy= (ListStructure) this.primaryList.clone();
                copy.setCreater(new PrimaryKey(copy,startPrimary));
                newT.listStructureList.add(copy);
            } else {
                newT.listStructureList.add((ListStructure) this.listStructureList.get(loop).clone());
            }
        }
        newT.tbname = this.tbname;
        newT.MaxListRange = this.MaxListRange;
        newT.listnamessb = this.listnamessb;
        newT.unmake = this.unmake;
        newT.hasPrimary=this.hasPrimary;
        return newT;
    }

    public String getTbname() {
        return tbname;
    }

    public void setTbname(String tbname) {
        this.tbname = tbname;
    }

    public boolean isUnmake() {
        return unmake;
    }

    public String getListnames() {
        return listnamessb.toString();
    }

    public void setPrimaryInterval(BigInteger primaryInterval) {
        this.primaryInterval=primaryInterval;
        startPrimary = primaryInterval.negate();
    }

    public boolean isPrimary(){
        return this.hasPrimary;
    }

    public ListStructure getPrimaryList(){
        return isPrimary()?primaryList: numberStructureList.get(privateRandom.RandomInteger(0,numberStructureList.size()));
    }

    public ListStructure getStringStructureList() {
        return stringStructureList.get(privateRandom.RandomInteger(0,stringStructureList.size()));
    }

    public List<String> getForeignRely() {
        return foreignRely;
    }
}
