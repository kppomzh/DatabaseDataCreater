package CreateSQLParser.Lex;

public class Word {
    String name;//单词的实际名称，如果是常量的话就写常量的类型名称
    String substance;//单词的实际内容，只对常量、对象名称有效
    boolean isMark;//简单表示这是一个符号而不是单词

    public Word(String c_name, String c_substance) {
        name = c_name;
        substance = c_substance;
    }

    /**
     * @param c_name
     * @param c_substance
     * @param ismark
     */
    public Word(String c_name, String c_substance, boolean ismark) {
        name = c_name;
        substance = c_substance;
        isMark = ismark;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSubstance(String substance) {
        this.substance = substance;
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
}
