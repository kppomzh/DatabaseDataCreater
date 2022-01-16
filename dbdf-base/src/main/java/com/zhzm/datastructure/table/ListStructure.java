package com.zhzm.datastructure.table;

/**
 * 表字段数据结构
 */
public class ListStructure {
    private String listname;//字段名称
    private String listType;//字段数据类型,string,number,date三类
    private int[] Range;//字段长度
    private String[] Numberarea;//数值类型的取值范围
    private boolean isSingal=false//是否存在唯一约束
            , isPrimary=false //是否存在主键约束
            , isForeign=false //是否存在外键约束
            , rely =false;   //是否是其他表的外键
    private String foreignTable,foreignList;
    private boolean unmake;//是否对本字段进行填充

    private boolean isAdvancedType=false;//已命名的默认字符串格式
    private String advancedType;//默认字符串格式

    private boolean isDefault=false;//是否采用默认值填充
    private String defaultStr;//默认值

    private boolean isRegular=false;//是否用正则表达式生成字段
    private String regularWord;//正则表达式所在的单词

    private boolean isInline=false;//是否采用inline方式填充
    private String[] inlineObject;//inline可选范围

    public ListStructure() {
        Range = new int[0];
    }

    public void setAdvancedType(String advancedType, boolean isStringType) {
        this.advancedType = advancedType;
        this.isAdvancedType = isStringType;
    }

    public void setRange(int... range) {
        Range = range;
    }

    public void setInlineObject(String[] inlineObject) {
        isInline = true;
        this.inlineObject = inlineObject;
        if (Range.length == 0)
            return;
        else if (this.getListType().equals("string"))
            for (int loop = 0; loop < inlineObject.length; loop++)
                if (inlineObject[loop].length() > this.Range[0])
                    throw new RuntimeException(this.listname + "的可选值\"" + inlineObject[loop] + "\"存在越界");
    }

    public void setNumberarea(String[] numberarea) {
        Numberarea = numberarea;
    }

    public void setUnmake(boolean unmake) {
        this.unmake = unmake;
    }

    public void setRegularStr(String regular) {
        this.isRegular = true;
        this.regularWord = regular;
    }

    public void setDefaultStr(String defaultStr) {
        isDefault = true;
        this.defaultStr = defaultStr;
    }

    public void setSingal(boolean singal) {
        if (singal) {
            isInline = false;
            isDefault = false;
            isSingal = singal;
        }
    }

    public void setPrimary(boolean primary) {
        isPrimary = primary;
    }

    public String getListType() {
        return listType;
    }

    public int[] getRange() {
        return Range;
    }

    public String getDefaultStr() {
        return defaultStr;
    }

    public String getAdvancedType() {
        return advancedType;
    }

    public String getListname() {
        return listname;
    }

    public String[] getNumberarea() {
        return Numberarea;
    }

    public String[] getInlineObjects() {
        return inlineObject;
    }

    public String getRegularWord() {
        return regularWord;
    }

    public boolean isInline() {
        return isInline;
    }

    public boolean isUnmake() {
        return unmake;
    }

    public boolean isRegular() {
        return isRegular;
    }

    public boolean isSingal() {
        return isSingal;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public boolean isAdvancedType() {
        return isAdvancedType;
    }

    public boolean isPrimary() {
        return isPrimary;
    }

    public boolean isForeign() {
        return isForeign;
    }

    public String getForeignTable() {
        return foreignTable;
    }

    public void setForeignKey(String foreignTable,String foreignList) {
        if(isPrimary)
            return;
        isForeign = true;
        isInline=false;
        isRegular=false;
        isDefault=false;
        isSingal=false;
        isAdvancedType=false;
        this.foreignTable = foreignTable;
        this.foreignList = foreignList;
    }

    public String getForeignList() {
        return foreignList;
    }

    public void setRely() {
        rely = true;
    }

    public boolean isRely() {
        return rely;
    }

    public void setListname(String listname) {
        this.listname = listname;
    }

    public void setListType(String listType) {
        this.listType = listType;
    }
}
