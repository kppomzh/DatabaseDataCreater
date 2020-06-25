package dataStructure;

import DataCreater.TypeCreater.Advanced.PrimaryKey;
import Exception.DataException.TableStrucDataException;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class TableStructure implements Cloneable {
    private int MaxListRange = 0;//本表中的最大字段长度
    private String tbname;//表名
    private StringBuilder listnamessb;//需要填充的字段名总和
    private List<ListStructure> listStructureList;
    private int readnum = -1;
    private boolean unmake = false;//是否存在不需要填充的字段
    private boolean hasPrimary = false;
    private ListStructure primaryList;
    private BigInteger startPrimary,primaryInterval;

    public TableStructure() {
        listnamessb = new StringBuilder();
        listStructureList = new ArrayList<>();
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

        if(ls.isUnmake()){
            unmake=true;
        } else{
            if (listnamessb.length() != 0)
                listnamessb.append(',');

            listnamessb.append(ls.getListname());
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
}
