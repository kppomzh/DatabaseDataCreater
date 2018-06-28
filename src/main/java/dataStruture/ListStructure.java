package dataStruture;

import Utils.env_properties;

public class ListStructure implements Cloneable{
    private String listname;
    private String ListType;
    private int[] Range;
    private boolean isSingal;
    private boolean isDefault;
    private String defaultType;
    private String defaultStr;

    public ListStructure(String listname,String ListType,String defaultDataType,boolean isSingal,boolean isDefault,String defaultStr,int... Range)
    {
        this.listname=listname;
        this.isSingal=isSingal;
        this.ListType =ListType;
        this.Range=Range;
        this.defaultType=defaultDataType;
        this.isDefault=isDefault;
        this.defaultStr=defaultStr;
    }

    public String getListType() {
        return ListType;
    }

    public int[] getRange() {
        return Range;
    }
    public String getDefaultStr() {
        return defaultStr;
    }

    public boolean isSingal() {
        return isSingal;
    }
    public boolean isDefault(){ return isDefault; }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getDefaultType() {
        return defaultType;
    }

    public String getListname() {
        return listname;
    }
}
