package CreateSQLParser.Lex;

public class Word {
    String name;//单词的实际名称，如果是常量的话就写常量的类型名称
    String substance;//单词的实际内容，只对常量、对象名称有效
    boolean isMark;//简单表示这是一个符号而不是单词
    private int line,list;//首字母所在行/列

    /**
     * @param c_name
     * @param c_substance
     * @param ismark
     */
    public Word(String c_name, String c_substance, boolean ismark,int nowline,int nowlist) {
        name = c_name;
        substance = c_substance;
        isMark = ismark;
        line=nowline;
        list=nowlist;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Word setSubstance(String substance) {
        this.substance = substance;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getSubstance() {
        return this.substance;
    }

    public boolean isMark() {
        return this.isMark;
    }

    @Override
    public String toString() {
        if (substance != null)
            return substance;
        else
            return name;
    }

    public int getLine() {
        return line;
    }

    public int getList() {
        return list;
    }
}
