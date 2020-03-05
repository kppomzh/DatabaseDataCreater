package dataStructure;

import Exception.DataException.TableStrucDataException;
import DataCreater.RegularCreater.Regular;
import Utils.Factorys.TypeCreaterFactory;

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
    private BigInteger startPrimary,primaryInterval;

    public TableStructure() {
        listnamessb = new StringBuilder();
        listStructureList = new ArrayList<>();
        startPrimary=BigInteger.ZERO;
    }

    public void addlist(String listname, String ListType, String defaultDataType, boolean isSingal, boolean isDefault, boolean isAdvancedType, String defaultStr, int[] Range, String[] Numberarea, List<String> inlineObject, boolean unmake, boolean isRegular, Regular regular, boolean isPrimary) throws TableStrucDataException {
        if (Range[0] > MaxListRange)
            MaxListRange = Range[0];
        if(hasPrimary&&isPrimary){
            throw new TableStrucDataException("同一个表中不允许有两个主键");
        }
        else{
            hasPrimary=hasPrimary||isPrimary;
        }
        ListStructure ls = new ListStructure(listname, ListType, isSingal, isPrimary, isDefault, isRegular, defaultStr);
        ls.setAdvancedType(defaultDataType,isAdvancedType);
        ls.setRange(Range);
        ls.setNumberarea(Numberarea);
        ls.setRegularStr(regular);
        if (inlineObject.size() != 0)
            ls.setInlineObject(inlineObject.toArray(new String[0]));
        ls.setUnmake(unmake);
        if (!unmake) {
            if (listnamessb.length() != 0)
                listnamessb.append(',');

            listnamessb.append(listname);
        } else
            this.unmake = true;
        ls.setCreater(TypeCreaterFactory.getTypeCreater(ls));
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
        if (readnum == listStructureList.size())
            readnum = -1;
        return listStructureList.get(readnum);
    }

    public List<ListStructure> getStruc() {
        return listStructureList;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        TableStructure newT = new TableStructure();
        for (int loop = 0; loop < this.listStructureList.size(); loop++)
            newT.listStructureList.add((ListStructure) this.listStructureList.get(loop).clone());
        newT.tbname = this.tbname;
        newT.MaxListRange = this.MaxListRange;
        newT.listnamessb = this.listnamessb;
        newT.unmake = this.unmake;
        newT.hasPrimary=this.hasPrimary;
        if(hasPrimary) {
            this.startPrimary = this.startPrimary.add(this.primaryInterval);
            newT.startPrimary = this.startPrimary;
        }
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

    public BigInteger getStartPrimary() {
        return startPrimary;
    }

    public void setPrimaryInterval(BigInteger primaryInterval) {
        this.primaryInterval=primaryInterval;
        startPrimary = primaryInterval.negate();
    }

    public boolean isPrimary(){
        return this.hasPrimary;
    }
}
