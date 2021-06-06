package dataStructure;

import DataCreater.TypeCreater.Advanced.PrimaryKey;
import DataCreater.TypeCreater.baseTypeCreater;
import DataCreater.TypeCreater.relyTypeCreater;
import Exception.DataException.TableStrucDataException;
import Utils.ArraySetList;
import Utils.privateRandom;

import java.math.BigInteger;
import java.util.*;

public class TableStructure implements Cloneable {
    private int MaxListRange = 0;//本表中的最大字段长度
    private String tbname;//表名
    private StringBuilder listnamessb;//需要填充的字段名总和
    private List<String> listnames;
    private LinkedHashMap<String,ListStructure> listStructureList;
    private List<ListStructure> numberStructureList,stringStructureList;
    private int readnum = -1;
    private boolean unmake = false;//是否存在不需要填充的字段
    private boolean hasPrimary = false;
    private ListStructure primaryList;
    private BigInteger startPrimary,primaryInterval;
    private double size;
    private List<String> foreignRelyTable;

    public TableStructure() {
        listnamessb = new StringBuilder();
        listnames=new ArrayList<>();
        listStructureList = new LinkedHashMap<>();
        numberStructureList=new ArrayList<>();
        stringStructureList=new ArrayList<>();
        foreignRelyTable =new LinkedList<>();
        startPrimary=BigInteger.ZERO;
    }

    public void addList(ListStructure ls) throws TableStrucDataException {
        if(hasPrimary&&ls.isPrimary()) {
            throw new TableStrucDataException("同一个表中不允许有两个主键");
        } else{
            if (ls.isPrimary()) {
                hasPrimary=true;
                primaryList=ls;
            }
        }

        if(ls.isForeign()){
            foreignRelyTable.add(ls.getForeignTable());
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
        listnames.add(ls.getListname());
        listStructureList.put(ls.getListname(),ls);
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
        return listStructureList.get(listnames.get(readnum));
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        TableStructure newT = new TableStructure();
        if(hasPrimary) {
            this.startPrimary = this.startPrimary.add(this.primaryInterval);
            newT.startPrimary = this.startPrimary;
        }

        for (ListStructure ls:listStructureList.values()) {
            if(ls.isPrimary()){
                ListStructure copy= (ListStructure) this.primaryList.clone();
                baseTypeCreater bccp=new PrimaryKey(copy,startPrimary);
                if(ls.isRely()){
                    bccp=new relyTypeCreater(bccp,primaryList.getRelyContent());
                }
                copy.setCreater(bccp);
                newT.listStructureList.put(ls.getListname(),copy);
            } else {
                newT.listStructureList.put(ls.getListname(),(ListStructure) ls.clone());
            }
        }
        newT.tbname = this.tbname;
        newT.MaxListRange = this.MaxListRange;
        newT.listnamessb = this.listnamessb;
        newT.listnames=this.listnames;
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

    public boolean hasForeign(){
        return !foreignRelyTable.isEmpty();
    }

    public List<String> getForeignRelyTable() {
        return foreignRelyTable;
    }

    public ListStructure getStructureList(String listname) {
        return listStructureList.get(listname);
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }
}
