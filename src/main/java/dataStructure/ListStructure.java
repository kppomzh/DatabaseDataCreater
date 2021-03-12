package dataStructure;

import CreateSQLParser.Lex.Word;
import DataCreater.TypeCreater.baseTypeCreater;
import DataCreater.TypeCreater.relyTypeCreater;

import java.util.ArrayList;
import java.util.List;

/**
 * 表字段数据结构
 */
public class ListStructure implements Cloneable {
    private String listname;//字段名称
    private String ListType;//字段数据类型,string,number,date三类
    private int[] Range;//字段长度
    private String[] Numberarea;//数值类型的取值范围
    private boolean isSingal=false//是否存在唯一约束
            , isPrimary=false //是否存在主键约束
            , isForeign=false //是否存在外键约束
            , isRely=false;   //是否是其他表的外键
    private String foreignTable,foreignList;
    private boolean unmake;//是否对本字段进行填充

    private boolean isAdvancedType=false;//已命名的默认字符串格式
    private String advancedType;//默认字符串格式

    private boolean isDefault=false;//是否采用默认值填充
    private String defaultStr;//默认值

    private boolean isRegular=false;//是否用正则表达式生成字段
    private Word regularWord;//正则表达式所在的单词

    private boolean isInline=false;//是否采用inline方式填充
    private String[] inlineObject;//inline可选范围
    private baseTypeCreater creater;//用于自动生成数据的creater

    private List<String> relyContent;//如果是其他表的外键，则该字段的所有内容都会被填写到这个集合种
    /**
     * @param listname
     * @param ListType
     */
    public ListStructure(String listname, String ListType) {
        this.listname = listname;
        this.ListType = ListType;
        Range = new int[0];
    }

    public void setAdvancedType(String advancedType, boolean isStringType) {
        this.advancedType = advancedType;
        this.isAdvancedType = isStringType;
    }

    public void setRange(int[] range) {
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

    public void setRegularStr(Word regular) {
        this.isRegular = true;
        this.regularWord = regular;
    }

    public void setCreater(baseTypeCreater creater) {
        this.creater = creater;
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
        return ListType;
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

    public Word getRegularWord() {
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


    public String getString() {
        return creater.getString();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
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

    public List<String> getRelyContent() {
        return relyContent;
    }

    public void setRely() {
        isRely = true;
        relyContent=new ArrayList<>();
        creater=new relyTypeCreater(creater,relyContent);
    }
}
