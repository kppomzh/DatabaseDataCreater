package CreateSQLParser.Plan;

import Utils.Factorys.getRegularElementsFactory;
import dataStructure.RegularClasses.*;

import java.util.Stack;

public class RegularPlanMaker {
    public static Regular makeRegular(String regularStr) throws Exception {
        Stack<MetaString> metaStack=new Stack<>();
        MetaString root=new MetaString(),temp=root;
        StringBuilder sb=new StringBuilder();

        for(int loop = 0; loop < regularStr.length(); loop++) {
            switch (regularStr.charAt(loop)){
                case '(':
                    metaStack.push(temp);
                    temp=new MetaString();
                    break;
                case ')':
                    temp=metaStack.pop().addElement(temp);
                    break;
                case '{':
                    //此后第一个逗号位置
                    int local1=regularStr.indexOf(",",loop);
                    int local2=regularStr.indexOf("}",loop);
                    if(local1!=-1&&local1<local2) {
                        int minlength = Integer.valueOf(regularStr.substring(loop + 1, local1));
                        String maxlengthS = regularStr.
                                substring(local1 + 1, local2);
                        int maxlength = maxlengthS.equals("") ? null : Integer.valueOf(maxlengthS);
                        temp.addElement(new LengthExpression(minlength, maxlength));
                    }
                    else{
                        int replaceNum=Integer.valueOf(regularStr.substring(loop+1,local2));
                        temp.addElement(new LengthExpression(replaceNum));
                    }
                    loop=local2;
                    break;
                case '[':
                    int local=regularStr.indexOf("]",loop);
                    BracketExpression be=new BracketExpression();
                    char tempC;
                    for(int loopi = loop+2; loopi < local-1; loopi++) {
                        tempC = regularStr.charAt(loopi - 1);
                        if (regularStr.charAt(loopi) == '-') {
                            if (regularStr.charAt(loopi + 1) > tempC) {
                                be.addFiled(tempC,regularStr.charAt(loopi + 1));
                                loopi = loopi + 2;
                            } else throw new Exception(regularStr.substring(loopi - 1, loopi + 1) + ":正则表达式的字符范围必须由小到大");
                        } else {
                            be.addFiled(tempC);
                        }
                    }
                    temp.addElement(be);
                    loop=local;
                    break;
                case '|':
                    temp.addElement(new OrSeparator());
                    break;
                default:
                    sb.append(regularStr.charAt(loop));
                    if(getRegularElementsFactory.getInstance().checkREle(sb.toString())){
                        temp.addElement(getRegularElementsFactory.getInstance().makeRegularElement(sb.toString()));
                        sb=new StringBuilder();
                    }
                    else if(loop==regularStr.length()-1||(
                            regularStr.charAt(loop+1)=='|'||
                            regularStr.charAt(loop+1)=='('||
                            regularStr.charAt(loop+1)==')'||
                            regularStr.charAt(loop+1)=='{'||
                            regularStr.charAt(loop+1)=='['||
                            regularStr.charAt(loop+1)=='\\')){
                        temp.addElement(new NmetaString(sb.toString()));
                        sb=new StringBuilder();
                    }
            }
        }

        return root;
    }
}
