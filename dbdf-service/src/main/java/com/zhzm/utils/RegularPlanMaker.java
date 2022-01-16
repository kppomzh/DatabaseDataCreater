package com.zhzm.utils;

import com.zhzm.datacreater.factory.RegularElementsFactory;
import com.zhzm.datacreater.typecreater.RegularCreater.*;
import com.zhzm.exceptions.BaseException;
import com.zhzm.exceptions.regular.*;
import com.zhzm.exceptions.regular.NullEndPointException;

import java.util.Stack;

public class RegularPlanMaker {
    public static MetaString makeRegular(String regular) throws BaseException, RegularBaseException {
        Stack<MetaString> metaStack = new Stack<>();
        MetaString root = new MetaString(), temp = root;
        StringBuilder sb = new StringBuilder();

        int loop = 0;

        for (; loop < regular.length(); loop++) {
            switch (regular.charAt(loop)) {
                case '(':
                    temp.addElement(new NmetaString(sb.toString()));
                    sb = new StringBuilder();
                    metaStack.push(temp);
                    temp = new MetaString();
                    break;
                case '{':
                    temp.addElement(new NmetaString(sb.toString()));
                    sb = new StringBuilder();

                    //此后第一个逗号位置
                    int local1 = regular.indexOf(",", loop);
                    int local2 = regular.indexOf("}", loop);
                    if (local2 == -1) {
                        throw new NullEndPointException(regular,loop);
                    }

                    if (local1 != -1 && local1 < local2) {
                        int minlength = Integer.parseInt(regular.substring(loop + 1, local1));
                        String maxlengthS = regular.
                                substring(local1 + 1, local2);
                        int maxlength = maxlengthS.equals("") ? -1 : Integer.parseInt(maxlengthS);
                        if(minlength<0)
                            throw new LengthDefineException("正则表达式的元字符最小长度不能小于0。",loop);
                        if(maxlength>=0&&minlength>maxlength){
                            throw new LengthDefineException("正则表达式的元字符最小长度不能大于最大长度。",loop);
                        }
                        temp.addElement(new LengthExpression(minlength, maxlength));
                    } else {
                        int replaceNum = Integer.parseInt(regular.substring(loop + 1, local2));
                        if(replaceNum<0)
                            throw new LengthDefineException("正则表达式的元字符最小长度不能小于0。",loop);
                        temp.addElement(new LengthExpression(replaceNum));
                    }
                    loop = local2;
                    break;
                case '[':
//                    tempreg = new Word("regularPart", "[", false, regular.getLine(), regular.getList() + loop);
                    temp.addElement(new NmetaString(sb.toString()));
                    sb = new StringBuilder();

                    int local = regular.indexOf("]", loop);
                    String beString;
                    if(local!=-1){
                        beString = regular.substring(loop, local);
                    }
                    else{
                        throw new NullEndPointException(regular.substring(loop),loop);
                    }

                    if(local==loop+1){
                        throw new NullBracketException("[]",local,loop);
                    }
                    BracketExpression be = new BracketExpression();
                    char tempC;
                    for (int loopi = loop + 1; loopi < local; loopi++) {
                        tempC = regular.charAt(loopi);
                        if (tempC == '\\') {
                            loopi++;
                            if (regular.charAt(loopi) != '-') {
                                be.addFiled(tempC);
                            }
                            be.addFiled(regular.charAt(loopi));
                        } else if (regular.charAt(loopi + 1) == '-') {
                            if (regular.charAt(loopi + 2) > tempC) {
                                be.addFiled(tempC, regular.charAt(loopi + 1));
                                loopi = loopi + 2;
                            } else
                                throw new BucketFiledException(beString,loop+loopi);
                        } else {
                            be.addFiled(tempC);
                        }
                    }
                    temp.addElement(be);
                    loop = local;
                    break;
                case ')':
//                    tempreg=new Word("regularPart",")",false,regular.getLine(),regular.getList()+loop);
                    temp.addElement(new NmetaString(sb.toString()));
                    sb = new StringBuilder();

                    temp = metaStack.pop().addElement(temp);
                    break;
                case '|':
//                    tempreg=new Word("regularPart","|",false,regular.getLine(),regular.getList()+loop);
                    temp.addElement(new NmetaString(sb.toString()));
                    sb = new StringBuilder();

                    temp.addElement(new OrSeparator());
                    break;
                case '\\':
                    temp.addElement(new NmetaString(sb.toString()));
                    sb = new StringBuilder();
                    loop = EscapeCharacterProcess(sb, temp, loop, regular);
                    if(loop==-1){
                        throw new EscapeCharacterException(sb.toString(),loop);
                    }
                    break;
                default:
                    if(RegularElementsFactory.getInstance().checkREle(regular.charAt(loop))){
                        temp.addElement(RegularElementsFactory.getInstance().makeRegularElement(regular.charAt(loop)));
                        sb=new StringBuilder();
                    }
                    else
                        sb.append(regular.charAt(loop));
                    break;
            }
        }
        temp.addElement(new NmetaString(sb.toString()));

        return root;
    }

    private static int EscapeCharacterProcess(StringBuilder sb, MetaString temp, int loop, String regularStr) throws BaseException {
        if (RegularElementsFactory.getInstance().checkREle(regularStr.charAt(loop + 1))) {
            temp.addElement(RegularElementsFactory.getInstance().makeRegularElement(regularStr.charAt(loop + 1)));
            return loop + 1;
        }

        switch (regularStr.charAt(loop + 1)) {
            case 'n':
                //\num这个进行特殊处理
                if (regularStr.charAt(loop + 2) == 'u' && regularStr.charAt(loop + 3) == 'm') {
                    temp.addElement(RegularElementsFactory.getInstance().makeRegularElement('n'));
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
