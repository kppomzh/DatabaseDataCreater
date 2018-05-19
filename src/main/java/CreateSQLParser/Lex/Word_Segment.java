package CreateSQLParser.Lex;

import java.util.LinkedList;

public class Word_Segment {

    LinkedList<Word> LW;//主SQL序列
    Coolean status;
    String toSQL;
    int nowline, nowlist, streamPoint = 0;

    public Word_Segment() {
        LW = new LinkedList<>();
        nowline = 1;
        nowlist = 0;
    }

    public LinkedList<Word> Segment(String content) throws Exception {
        streamPoint = 0;
        LW.clear();
        toSQL = content;
        StringBuffer toWord = new StringBuffer();
        status = Coolean.letter;
        for (int loop = 0; loop < toSQL.length(); loop++) {
            nowlist++;
            char c = toSQL.charAt(loop);
            Coolean nowstatus = c_BuildWord(c);
            boolean isStop = nowstatus.equals(Coolean.stop);//
            boolean charStop = charStop(nowstatus);//
            boolean single_quotation = (c == '\'');//判断是否转入String类型处理函数
            boolean double_quotation = (c == '\"');
            boolean Stop = isStop | charStop | single_quotation;

            if (Stop && toWord.length() != 0) {
                String isWord = toWord.toString().toLowerCase();//统一转换成小写
                if (single_quotation)
                {
                    StringBuffer quo = new StringBuffer();
                    create_word_and_add(isWord, null);
                    Integer cp_length = Stringinquotation(loop, quo);
                    create_word_and_add("String", quo.toString());
                    loop = loop + cp_length;//loop停在后面的单引号上
                    nowstatus = Coolean.mark;
                    toWord.delete(0, toWord.length());
                    continue;
                }
                else if(double_quotation)
                {
                    StringBuffer quo = new StringBuffer();
                    create_word_and_add(isWord, null);
                    Integer cp_length = varnameinquotation(loop,quo);
                    create_word_and_add(quo.toString(), null);
                    loop = loop + cp_length;//loop停在后面的单引号上
                    nowstatus = Coolean.mark;
                }
                else {
                    create_word_and_add(isWord, null);
                }
                toWord.delete(0, toWord.length());
            }

            if (!nowstatus.equals(Coolean.stop)) {
                toWord.append(c);
            }

            status = nowstatus;
        }
        create_word_and_add(";", null);

        return LW;
    }

    private void build_undefined_var(String isWord) throws Exception {
        boolean nocreate = true;
        if (status.equals(Coolean.mark))
            throw new Exception(nowline + nowlist + isWord + "符号不存在");

        else
            create_word_and_add(isWord, null);
    }

    private Coolean c_BuildWord(char c) throws Exception {
        switch (c) {
            case '\n'://遇到换行符将行列数据刷新
                nowline = nowline + 1;
                nowlist = 0;
            case ' ':
            case '\r':
            case ';':
                //识别为stop的时候不将当前字符列为单词
                //case '\''://但是单引号是特例，另有专门的方法处理
                return Coolean.stop;

            case '(':
            case ')':
            case '!':
            case '%':
            case '*':
            case '+':
            case ',':
            case '-':
            case '/'://46是'.'，要作为小数点保留//case '\"':
            case ':':
            case '<':
            case '=':
            case '>':
            case '^':
            case '\'':
            case '\"':
                return Coolean.mark;//识别为mark的时候将当前字符列为单词

            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
            case 'a':
            case 'b':
            case 'c':
            case 'd':
            case 'e':
            case 'f':
            case 'g':
            case 'h':
            case 'i':
            case 'j':
            case 'k':
            case 'l':
            case 'm':
            case 'n':
            case 'o':
            case 'p':
            case 'q':
            case 'r':
            case 's':
            case 't':
            case 'u':
            case 'v':
            case 'w':
            case 'x':
            case 'y':
            case 'z':
            case 'A':
            case 'B':
            case 'C':
            case 'D':
            case 'E':
            case 'F':
            case 'G':
            case 'H':
            case 'I':
            case 'J':
            case 'K':
            case 'L':
            case 'M':
            case 'N':
            case 'O':
            case 'P':
            case 'Q':
            case 'R':
            case 'S':
            case 'T':
            case 'U':
            case 'V':
            case 'W':
            case 'X':
            case 'Y':
            case 'Z':
            case '.':
            case '_':
                return Coolean.letter;
            default:
                throw new Exception(nowline + nowlist + "该字符是非法字符");
        }
    }

    private Integer Stringinquotation(int loopo, StringBuffer str) throws Exception {
        //loopo是引号所在的位置
        char stop = '\'';
        int loop = 1;
        while (true) {
            nowlist++;
            if (loopo + loop == toSQL.length() - 1)
                throw new Exception(nowline + nowlist + "没有终结符号的字符串");
            if (toSQL.charAt(loopo + loop) == '\n') {
                nowline = nowline + 1;
                nowlist = 0;
            }
            if (toSQL.charAt(loopo + loop) == stop)//应对标准形式的Oeacle单引号转义
            {
                if (toSQL.charAt(loopo + loop + 1) == stop) {
                    str.append(stop);
                    loop++;
                } else
                    break;
            } else
                str.append(toSQL.charAt(loopo + loop));
            loop++;
        }
        //最后要将生成的String和String的结尾位置返回上层函数，同时将整个String视为一个"字"
        status = Coolean.letter;
        return loop;
    }
    private Integer varnameinquotation(int loopo, StringBuffer str) throws Exception {
        //loopo是引号所在的位置，单引号和双引号区间内不同种引号的识别情况
        char stop = '\"';
        int loop = 1;
        while (true) {
            nowlist++;
            if (loopo + loop == toSQL.length() - 1)
                throw new Exception(nowline + nowlist + "没有终结符号的字符串");

            if (toSQL.charAt(loopo + loop) == stop)
            {
                break;
            } else
                str.append(toSQL.charAt(loopo + loop));
            loop++;
        }
        //最后要将生成的String和String的结尾位置返回上层函数，同时将整个String视为一个"字"
        status = Coolean.letter;
        return loop;
    }

    //生成简单SQL关键字的方法
    private void create_word_and_add(String name, String substance) {
        Word word;
        if (name.equals("String"))
            word = new Word(name, substance, nowline, nowlist - substance.length(), status.equals(Coolean.mark));
        else
            word = new Word(name, substance, nowline, nowlist - name.length(), status.equals(Coolean.mark));
        LW.add(word);
    }

    //通过status和nowstatus的取值和相互关系得出是否继续读入字符
    private boolean charStop(Coolean nowstatus) {
        if (status.equals(Coolean.stop))
            return false;
        else if (status.equals(nowstatus) && status.equals(Coolean.letter))
            return false;
        else
            return true;
    }
}
