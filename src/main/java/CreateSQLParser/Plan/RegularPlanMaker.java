package CreateSQLParser.Plan;

import CreateSQLParser.Lex.Word;
import Exception.RegularException.*;
import Utils.Factorys.getRegularElementsFactory;
import dataStructure.RegularClasses.*;

import java.util.Stack;

public class RegularPlanMaker {
    public static Regular makeRegular(Word regular) throws BaseException {
        Stack<MetaString> metaStack = new Stack<>();
        MetaString root = new MetaString(), temp = root;
        StringBuilder sb = new StringBuilder();
        String regularStr = regular.getSubstance();

        int loop = 0;

        for (; loop < regularStr.length(); loop++) {
            switch (regularStr.charAt(loop)) {
                case '(':
                    temp.addElement(new NmetaString(sb.toString()),regular);
                    sb = new StringBuilder();
                    metaStack.push(temp);
                    temp = new MetaString();
                    break;
                case '{':
                    temp.addElement(new NmetaString(sb.toString()),regular);
                    sb = new StringBuilder();

                    //此后第一个逗号位置
                    int local1 = regularStr.indexOf(",", loop);
                    int local2 = regularStr.indexOf("}", loop);
                    if (local1 != -1 && local1 < local2) {
                        int minlength = Integer.valueOf(regularStr.substring(loop + 1, local1));
                        String maxlengthS = regularStr.
                                substring(local1 + 1, local2);
                        int maxlength = maxlengthS.equals("") ? null : Integer.valueOf(maxlengthS);
                        if(minlength<0)
                            throw new LengthDefineException(regular,"正则表达式的元字符最小长度不能小于0。");
                        if(maxlength>=0&&minlength>maxlength){
                            throw new LengthDefineException(regular,"正则表达式的元字符最小长度不能大于最大长度。");
                        }
                        temp.addElement(new LengthExpression(minlength, maxlength),regular);
                    } else {
                        int replaceNum = Integer.valueOf(regularStr.substring(loop + 1, local2));
                        if(replaceNum<0)
                            throw new LengthDefineException(regular,"正则表达式的元字符最小长度不能小于0。");
                        temp.addElement(new LengthExpression(replaceNum),regular);
                    }
                    loop = local2;
                    break;
                case '[':
                    temp.addElement(new NmetaString(sb.toString()),regular);
                    sb = new StringBuilder();

                    int local = regularStr.indexOf("]", loop);
                    if(local==loop+1){
                        throw new NullBracketException(regular);
                    }
                    BracketExpression be = new BracketExpression();
                    char tempC;
                    for (int loopi = loop + 1; loopi < local; loopi++) {
                        tempC = regularStr.charAt(loopi);
                        if (tempC == '\\') {
                            loopi++;
                            if (regularStr.charAt(loopi) != '-') {
                                be.addFiled(tempC);
                            }
                            be.addFiled(regularStr.charAt(loopi));
                        } else if (regularStr.charAt(loopi + 1) == '-') {
                            if (regularStr.charAt(loopi + 2) > tempC) {
                                be.addFiled(tempC, regularStr.charAt(loopi + 1));
                                loopi = loopi + 2;
                            } else
                                throw new BucketFiledException(regular,regularStr.substring(loopi - 1, loopi + 1));//临时替代
                        } else {
                            be.addFiled(tempC);
                        }
                    }
                    temp.addElement(be,regular);
                    loop = local;
                    break;
                case ')':
                    temp.addElement(new NmetaString(sb.toString()),regular);
                    sb = new StringBuilder();

                    temp = metaStack.pop().addElement(temp,regular);
                    break;
                case '|':
                    temp.addElement(new NmetaString(sb.toString()),regular);
                    sb = new StringBuilder();

                    temp.addElement(new OrSeparator(),regular);
                    break;
                case '\\':
                    temp.addElement(new NmetaString(sb.toString()),regular);
                    sb = new StringBuilder();
                    loop = EscapeCharacterProcess(sb, temp, loop, regularStr);
                    if(loop==-1){
                        throw new EscapeCharacterException(regular,"非法的转义字符");
                    }
                    break;
                default:
                    if(getRegularElementsFactory.getInstance().checkREle(regularStr.charAt(loop))){
                        temp.addElement(getRegularElementsFactory.getInstance().makeRegularElement(regularStr.charAt(loop)),regular);
                        sb=new StringBuilder();
                    }
                    else
                        sb.append(regularStr.charAt(loop));
                    break;
            }
        }
        temp.addElement(new NmetaString(sb.toString()),regular);

        return root;
    }

    private static int EscapeCharacterProcess(StringBuilder sb, MetaString temp, int loop, String regularStr) throws BaseException {
        if (getRegularElementsFactory.getInstance().checkREle(regularStr.charAt(loop + 1))) {
            temp.addElement(getRegularElementsFactory.getInstance().makeRegularElement(regularStr.charAt(loop + 1)),null);
            return loop + 1;
        }

        switch (regularStr.charAt(loop + 1)) {
            case 'n':
                //\num这个进行特殊处理
                if (regularStr.charAt(loop + 2) == 'u' && regularStr.charAt(loop + 3) == 'm') {
                    temp.addElement(getRegularElementsFactory.getInstance().makeRegularElement('n'),null);
                    return loop + 3;
                } else {
                    sb.append('\n');
                }
                break;
            case 'r':
                sb.append('\r');
                break;
            case 't':
                sb.append('\t');
                break;
            case '\'':
                sb.append('\'');
                break;
            case '\"':
                sb.append('\"');
                break;
            case 'b':
                sb.append('\b');
                break;
            case 'f':
                sb.append('\f');
                break;
            case '0':
                sb.append('\0');
                break;
            case '\\':
                sb.append('\\');
                break;
            case '[':
                sb.append('[');
                break;
            case ']':
                sb.append(']');
                break;
            case '{':
                sb.append('{');
                break;
            case '}':
                sb.append('}');
                break;
            case '(':
                sb.append('(');
                break;
            case ')':
                sb.append(')');
                break;
            case '|':
                sb.append('|');
                break;
            case '*':
                sb.append('*');
                break;
            case '?':
                sb.append('?');
                break;
            case '+':
                sb.append('+');
                break;
            default:
                return -1;
        }
        return loop + 1;
    }
}
