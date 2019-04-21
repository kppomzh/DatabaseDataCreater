package CreateSQLParser.Plan;

import Utils.Factorys.getRegularElementsFactory;
import dataStructure.RegularClasses.*;

import java.util.Stack;

public class RegularPlanMaker {
    public static Regular makeRegular(String regularStr) throws Exception {
        Stack<MetaString> metaStack = new Stack<>();
        MetaString root = new MetaString(), temp = root;
        StringBuilder sb = new StringBuilder();

        for (int loop = 0; loop < regularStr.length(); loop++) {
            switch (regularStr.charAt(loop)) {
                case '(':
                    temp.addElement(new NmetaString(sb.toString()));
                    sb = new StringBuilder();
                    metaStack.push(temp);
                    temp = new MetaString();
                    break;
                case ')':
                    temp.addElement(new NmetaString(sb.toString()));
                    sb = new StringBuilder();
                    temp = metaStack.pop().addElement(temp);
                    break;
                case '{':
                    temp.addElement(new NmetaString(sb.toString()));
                    sb = new StringBuilder();
                    //此后第一个逗号位置
                    int local1 = regularStr.indexOf(",", loop);
                    int local2 = regularStr.indexOf("}", loop);
                    if (local1 != -1 && local1 < local2) {
                        int minlength = Integer.valueOf(regularStr.substring(loop + 1, local1));
                        String maxlengthS = regularStr.
                                substring(local1 + 1, local2);
                        int maxlength = maxlengthS.equals("") ? null : Integer.valueOf(maxlengthS);
                        temp.addElement(new LengthExpression(minlength, maxlength));
                    } else {
                        int replaceNum = Integer.valueOf(regularStr.substring(loop + 1, local2));
                        temp.addElement(new LengthExpression(replaceNum));
                    }
                    loop = local2;
                    break;
                case '[':
                    temp.addElement(new NmetaString(sb.toString()));
                    sb = new StringBuilder();
                    int local = regularStr.indexOf("]", loop);
                    BracketExpression be = new BracketExpression();
                    char tempC;
                    for (int loopi = loop + 2; loopi < local - 1; loopi++) {
                        tempC = regularStr.charAt(loopi - 1);
                        if (tempC == '\\') {
                            be.addFiled(regularStr.charAt(loopi));
                            loopi++;
                        } else if (regularStr.charAt(loopi) == '-') {
                            if (regularStr.charAt(loopi + 1) > tempC) {
                                be.addFiled(tempC, regularStr.charAt(loopi + 1));
                                loopi = loopi + 2;
                            } else
                                throw new Exception(regularStr.substring(loopi - 1, loopi + 1) + ":正则表达式的字符范围必须由小到大");
                        } else {
                            be.addFiled(tempC);
                        }
                    }
                    temp.addElement(be);
                    loop = local;
                    break;
                case '|':
                    temp.addElement(new NmetaString(sb.toString()));
                    sb = new StringBuilder();
                    temp.addElement(new OrSeparator());
                    break;
                case '\\':
                    temp.addElement(new NmetaString(sb.toString()));
                    sb = new StringBuilder();
                    loop = EscapeCharacterProcess(sb, temp, loop, regularStr);
                    break;
                default:
                    sb.append(regularStr.charAt(loop));
                    break;
            }
        }
        temp.addElement(new NmetaString(sb.toString()));

        return root;
    }

    private static int EscapeCharacterProcess(StringBuilder sb, MetaString temp, int loop, String regularStr) throws Exception {
        if (getRegularElementsFactory.getInstance().checkREle(regularStr.charAt(loop + 1))) {
            temp.addElement(getRegularElementsFactory.getInstance().makeRegularElement(regularStr.charAt(loop + 1)));
            return loop + 1;
        }

        switch (regularStr.charAt(loop + 1)) {
            case 'n':
                //\num这个进行特殊处理
                if (regularStr.charAt(loop + 2) == 'u' && regularStr.charAt(loop + 3) == 'm') {
                    temp.addElement(getRegularElementsFactory.getInstance().makeRegularElement('n'));
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
                throw new Exception("非法的转义字符");
        }
        return loop + 1;
    }
}
