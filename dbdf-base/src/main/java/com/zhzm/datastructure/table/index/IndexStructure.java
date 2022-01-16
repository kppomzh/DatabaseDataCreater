package com.zhzm.datastructure.table.index;

import com.zhzm.ENUM.IndexType;

import java.util.ArrayList;
import java.util.List;

public class IndexStructure {
    protected String indexname;
    protected IndexType indextype;
    private String[] involvedList;
    private String foreignTableSpace, foreignTable, foreignList;
    private List<CheckOption> checkOptionList = new ArrayList<>();

    public void setIndexname(String name) {
        indexname = name;
    }

    public String getIndexname() {
        return indexname;
    }

    public void setIndextype(IndexType type) {
        indextype = type;
    }

    public IndexType getIndextype() {
        return indextype;
    }

    public String[] getInvolvedList() {
        return involvedList;
    }

    public void setInvolvedList(String... involvedList) {
        this.involvedList = involvedList;
    }

    public String getForeignTable() {
        return foreignTable;
    }

    public void setForeignTable(String foreignTable) {
        this.foreignTable = foreignTable;
    }

    public String getForeignList() {
        return foreignList;
    }

    public void setForeignList(String foreignList) {
        this.foreignList = foreignList;
    }

    public String getForeignTableSpace() {
        return foreignTableSpace;
    }

    public void setForeignTableSpace(String foreignTableSpace) {
        this.foreignTableSpace = foreignTableSpace;
    }

    public List<CheckOption> getCheckOptionList() {
        return checkOptionList;
    }

    public void addCheckOptionList(CheckOption checkOption) {
        this.checkOptionList.add(checkOption);
    }
}
