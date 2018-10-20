package dataStruture;

/**
 * 表字段数据结构
 */
public class ListStructure implements Cloneable {
    private String listname;//字段名称
    private String ListType;//字段数据类型
    private int[] Range;//长度
    private double[] Numberarea;//如果是数值型的话，定义取值范围
    private boolean isSingal;//是否存在唯一/主键约束
    private boolean isDefault;//是否采用默认值填充
    private boolean isInline;//是否采用inline方式填充
    private boolean unmake;//是否对本字段进行填充
    private String defaultType;//默认字符串格式
    private String defaultStr;//默认值
    private String[] inlineObject;

    public ListStructure(String listname, String ListType, boolean isSingal, boolean isDefault, String defaultStr) {
        this.listname = listname;
        this.isSingal = isSingal;
        this.ListType = ListType;
        this.isDefault = isDefault;
        this.defaultStr = defaultStr;
    }

    public void setDefaultType(String defaultType) {
        this.defaultType = defaultType;
    }

    public void setRange(int[] range) {
        Range = range;
    }

    public void setNumberarea(double[] numberarea) {
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

    public double[] getNumberarea() {
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
}
