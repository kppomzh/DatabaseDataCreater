package com.zhzm.datastructure.table;

import com.facebook.presto.jdbc.internal.jackson.annotation.JsonIgnore;
import com.zhzm.datastructure.table.index.IndexStructure;
import com.zhzm.exceptions.TableStrucDataException;
import com.zhzm.utils.BaseEnvironment;
import com.zhzm.utils.privateRandom;

import java.util.*;

public class TableStructure {
    private final String tableSpaceName, tableName, fullTableName;//表名
    private StringBuilder listnamessb;//需要填充的字段名总和
    private List<String> listnames;
    private LinkedHashMap<String, ListStructure> listStructureList;
    private List<ListStructure> numberStructureList, stringStructureList;
    private List<IndexStructure> indexes;
    @JsonIgnore
    private int readnum = -1;
    private boolean unmake = false;//是否存在不需要填充的字段
    private boolean hasPrimary = false;
    private ListStructure primaryList;
    private final List<String> foreignRelyTable;
    private double linenum = Double.parseDouble(BaseEnvironment.getEnvironment("defaultCreateNum", "100"));

    public TableStructure(String tablespaceName, String tableName) {
        this.tableSpaceName = tablespaceName;
        this.tableName = tableName;
        this.fullTableName = this.tableSpaceName + '.' + this.tableName;
        listnamessb = new StringBuilder();
        listnames = new ArrayList<>();
        listStructureList = new LinkedHashMap<>();
        numberStructureList = new ArrayList<>();
        stringStructureList = new ArrayList<>();
        foreignRelyTable = new LinkedList<>();
        indexes = new LinkedList<>();
    }

    public void addList(ListStructure ls) throws TableStrucDataException {
        if (hasPrimary && ls.isPrimary()) {
            throw new TableStrucDataException("同一个表中不允许有两个主键");
        } else {
            if (ls.isPrimary()) {
                hasPrimary = true;
                primaryList = ls;
            }
        }

        if (ls.isForeign()) {
            foreignRelyTable.add(ls.getForeignTable());
        }

        if (ls.isUnmake()) {
            unmake = true;
        } else {
            if (listnamessb.length() != 0)
                listnamessb.append(',');

            listnamessb.append(ls.getListname());
        }

        if (ls.getListType().equals("number")) {
            numberStructureList.add(ls);
        } else if (ls.getListType().equals("string")) {
            stringStructureList.add(ls);
        }
        listnames.add(ls.getListname());
        listStructureList.put(ls.getListname(), ls);
    }

    public void addIndexes(Collection<IndexStructure> structures) {
        indexes.addAll(structures);
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

    public String getTableName() {
        return tableName;
    }

    public boolean isUnmake() {
        return unmake;
    }

    public String getListnames() {
        return listnamessb.toString();
    }

    public boolean isPrimary() {
        return this.hasPrimary;
    }

    public ListStructure getPrimaryList() {
        return isPrimary() ? primaryList : numberStructureList.get(privateRandom.RandomInteger(0, numberStructureList.size()));
    }

    public ListStructure getStringStructureList() {
        return stringStructureList.get(privateRandom.RandomInteger(0, stringStructureList.size()));
    }

    public boolean hasForeign() {
        return !foreignRelyTable.isEmpty();
    }

    public List<String> getForeignRelyTable() {
        return foreignRelyTable;
    }

    public ListStructure getStructureList(String listname) {
        return listStructureList.get(listname);
    }

    public List<IndexStructure> getIndexes() {
        return indexes;
    }

    public String getTableSpaceName() {
        return tableSpaceName;
    }

    public String getFullTableName() {
        return fullTableName;
    }

    public double getLinenum() {
        return linenum;
    }

    public void setLinenum(double linenum) {
        this.linenum = linenum;
    }
}
