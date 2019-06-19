package dataStructure;

import dataStructure.RegularClasses.Regular;

/**
 * 表字段数据结构
 */
public class ListStructure implements Cloneable {
    private String listname;
    private String ListType;
    private int[] Range;
    private String[] Numberarea;
    private boolean isSingal;
    private boolean unmake;//是否对本字段进行填充

    private boolean isStringType;//已命名的默认字符串格式
    private String defaultType;//默认字符串格式

    private boolean isDefault;
    private String defaultStr;//默认值

    private boolean isRegular;
    private Regular regularStructure;

    private boolean isInline;//是否采用inline方式填充
    private String[] inlineObject;

    /**
     * @param listname 字段名称
     * @param ListType 字段数据类型
     * @param isSingal 是否存在唯一/主键约束
     * @param isDefault 是否采用默认值填充
     * @param isRegular 是否用正则表达式生成值
     * @param defaultStr 是否用默认值填充
     */
    public ListStructure(String listname, String ListType, boolean isSingal, boolean isDefault, boolean isRegular, String defaultStr) {
        this.listname = listname;
        this.isSingal = isSingal;
        this.ListType = ListType;
        this.isDefault = isDefault;
        this.isRegular = isRegular;
        this.defaultStr = defaultStr;
    }

    public void setDefaultType(String defaultType,boolean isStringType) {
        this.defaultType = defaultType;
        this.isStringType=isStringType;
    }

    public void setRange(int[] range) {
        Range = range;
    }

    public void setNumberarea(String[] numberarea) {
        Numberarea = numberarea;
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

    public boolean isDefault() {
        return isDefault;
    }

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

    public String[] getNumberarea() {
        return Numberarea;
    }

    public int getInlinelength() {
        return inlineObject.length - 1;
    }

    public String getInlineObject(int num) {
        return inlineObject[num];
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

    public boolean isInline() {
        return isInline;
    }

    public boolean isUnmake() {
        return unmake;
    }

    public void setUnmake(boolean unmake) {
        this.unmake = unmake;
    }

    public boolean isRegular() {
        return isRegular;
    }

    public String getRegularStr() {
        return regularStructure.getGeneratedString();
    }

    public void setRegularStr(Regular regular) {
        this.regularStructure = regular;
    }

    public boolean isStringType() {
        return isStringType;
    }
}
