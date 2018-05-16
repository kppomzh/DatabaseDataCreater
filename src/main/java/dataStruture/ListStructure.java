package dataStruture;

public class ListStructure implements Cloneable{
    private String ListType;
    private int[] Range;
    private boolean canbeNull;
    private boolean isSingal;
    private String defaultType;

    public ListStructure(String ListType,String defaultDataType,boolean canbeNull,boolean isSingal,int... Range)
    {
        this.canbeNull=canbeNull;
        this.isSingal=isSingal;
        this.ListType =ListType;
        this.Range=Range;
        this.defaultType=defaultDataType;
    }

    public String getListType() {
        return ListType;
    }

    public int[] getRange() {
        return Range;
    }

    public boolean isCanbeNull() {
        return canbeNull;
    }

    public boolean isSingal() {
        return isSingal;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getDefaultType() {
        return defaultType;
    }
}
