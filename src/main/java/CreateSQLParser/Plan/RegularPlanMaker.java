package CreateSQLParser.Plan;

import CreateSQLParser.Lex.Word;
import Exception.RegularException.*;
import Utils.Factorys.getRegularElementsFactory;
import dataStructure.RegularClasses.*;

import java.util.Stack;
import Exception.BaseException;

public class RegularPlanMaker {
    public static Regular makeRegular(Word regular) throws BaseException {
        Stack<MetaString> metaStack = new Stack<>();
        MetaString root = new MetaString(), temp = root;
        StringBuilder sb = new StringBuilder();
        String regularStr = regular.getSubstance();
        Word tempreg=null;

        int loop = 0;

        for (; loop < regularStr.length(); loop++) {
            switch (regularStr.charAt(loop)) {
                case '(':
                    temp.addElement(new NmetaString(sb.toString()),
                            new Word("regularPart", sb.toString(), false, regular.getLine(), regular.getList() + loop-sb.toString().length()));
                    sb = new StringBuilder();
                    metaStack.push(temp);
                    temp = new MetaString();
                    break;
                case '{':
                    tempreg=new Word("regularPart","{",false,regular.getLine(),regular.getList()+loop);
                    temp.addElement(new NmetaString(sb.toString()),
                            new Word("regularPart", sb.toString(), false, regular.getLine(), regular.getList() + loop-sb.toString().length()));
                    sb = new StringBuilder();

                    //此后第一个逗号位置
                    int local1 = regularStr.indexOf(",", loop);
                    int local2 = regularStr.indexOf("}", loop);
                    if(local2!=-1){
                        tempreg.setSubstance(regularStr.substring(loop, local2));
                    }
                    else{
                        throw new NullEndpointException(tempreg);
                    }

                    if (local1 != -1 && local1 < local2) {
                        int minlength = Integer.valueOf(regularStr.substring(loop + 1, local1));
                        String maxlengthS = regularStr.
                                substring(local1 + 1, local2);
                        int maxlength = maxlengthS.equals("") ? null : Integer.valueOf(maxlengthS);
                        if(minlength<0)
                            throw new LengthDefineException(new Word("regularPart",String.valueOf(minlength),false,regular.getLine(),regular.getList()+loop),"正则表达式的元字符最小长度不能小于0。");
                        if(maxlength>=0&&minlength>maxlength){
                            throw new LengthDefineException(tempreg,"正则表达式的元字符最小长度不能大于最大长度。");
                        }
                        temp.addElement(new LengthExpression(minlength, maxlength),tempreg);
                    } else {
                        int replaceNum = Integer.valueOf(regularStr.substring(loop + 1, local2));
                        if(replaceNum<0)
                            throw new LengthDefineException(new Word("regularPart",String.valueOf(replaceNum),false,regular.getLine(),regular.getList()+loop),"正则表达式的元字符最小长度不能小于0。");
                        temp.addElement(new LengthExpression(replaceNum),tempreg);
                    }
                    loop = local2;
                    break;
                case '[':
                    tempreg = new Word("regularPart", "[", false, regular.getLine(), regular.getList() + loop);
                    temp.addElement(new NmetaString(sb.toString()),
                            new Word("regularPart", sb.toString(), false, regular.getLine(), regular.getList() + loop-sb.toString().length()));
                    sb = new StringBuilder();

                    int local = regularStr.indexOf("]", loop);
                    if(local!=-1){
                        tempreg.setSubstance(regularStr.substring(loop, local));
                    }
                    else{
                        throw new NullEndpointException(tempreg);
                    }

                    if(local==loop+1){
                        throw new NullBracketException(tempreg.setSubstance("[]"));
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
                                throw new BucketFiledException(tempreg,regularStr.substring(loop,local));
                        } else {
                            be.addFiled(tempC);
                        }
                    }
                    temp.addElement(be,new Word("regularPart",be.getRealName(),false,regular.getLine(),regular.getList()+loop));
                    loop = local;
                    break;
                case ')':
                    tempreg=new Word("regularPart",")",false,regular.getLine(),regular.getList()+loop);
                    temp.addElement(new NmetaString(sb.toString()),new Word("regularPart",sb.toString(),false,regular.getLine(),regular.getList()+loop-sb.toString().length()));
                    sb = new StringBuilder();

                    temp = metaStack.pop().addElement(temp,tempreg);
                    break;
                case '|':
                    tempreg=new Word("regularPart","|",false,regular.getLine(),regular.getList()+loop);
                    temp.addElement(new NmetaString(sb.toString()),tempreg);
                    sb = new StringBuilder();

                    temp.addElement(new OrSeparator(),tempreg);
                    break;
                case '\\':
                    temp.addElement(new NmetaString(sb.toString()),new Word("regularPart",sb.toString(),false,regular.getLine(),regular.getList()+loop-sb.toString().length()));
                    sb = new StringBuilder();
                    loop = EscapeCharacterProcess(sb, temp, loop, regularStr);
                    if(loop==-1){
                        throw new EscapeCharacterException(new Word("regularPart",sb.toString(),false,regular.getLine(),regular.getList()+loop),"非法的转义字符");
                    }
                    break;
                default:
                    if(getRegularElementsFactory.getInstance().checkREle(regularStr.charAt(loop))){
                        temp.addElement(getRegularElementsFactory.getInstance().makeRegularElement(regularStr.charAt(loop)),new Word("regularPart",String.valueOf(regularStr.charAt(loop)),false,regular.getLine(),regular.getList()+loop));
                        sb=new StringBuilder();
                    }
                    else
                        sb.append(regularStr.charAt(loop));
                    break;
            }
        }
        temp.addElement(new NmetaString(sb.toString()),new Word("regularPart",sb.toString(),false,regular.getLine(),regular.getList()+loop));

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
