package DataCreater.RegularCreater;

import CreateSQLParser.Lex.Word;
import Exception.BaseException;
import Exception.RegularException.DoubleOrSeparatorException;
import Exception.RegularException.LengthDefineException;
import Exception.RegularException.NullMetaStringException;
import Utils.privateRandom;

import java.util.ArrayList;
import java.util.List;
import DataCreater.TypeCreater.baseTypeCreater;

public class MetaString implements Regular,baseTypeCreater {
    private ArrayList<Regular> regularList;
    private ArrayList<Integer> OrSeparatorLocal;
    private LengthExpression length;
    private Regular last;

    public MetaString(){
        regularList=new ArrayList<>();
        OrSeparatorLocal=new ArrayList<>();
        OrSeparatorLocal.add(-1);
        OrSeparatorLocal.add(0);
        last=null;
        try {
            //根据逻辑，这里的初始化不太可能出现异常
            length=new LengthExpression(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getRealName() {
        return "MetaString";
    }

    public MetaString addElement(Regular element, Word word) throws BaseException {
        switch(element.getRealName()){
            //元字符串长度不进入列表
            case "LengthExpression":
                if(last.getRealName().equals("MetaString")||
                    last.getRealName().equals("BracketExpression")||
                    last.getRealName().equals("NmetaString")||
                    last.getRealName().equals("SingalMetaChar")){
                    last.setLength((LengthExpression) element);
                }
                else{
                    throw new LengthDefineException(word,"只能对以下成分定义长度：元字符串、字符集合、固定字符串、转义元字符。");
                }
                break;
            case "OrSeparator":
                if(last==null||last.getRealName().equals("OrSeparator")){
                    throw new DoubleOrSeparatorException(word);
                }
                OrSeparatorLocal.add(OrSeparatorLocal.size()-1,regularList.size());
                OrSeparatorLocal.set(OrSeparatorLocal.size()-1,regularList.size());
                break;
            case "BracketExpression":
            case "MetaString":
                if(element.getRegularLength()==0){
                    throw new NullMetaStringException(word);
                }
            case "NmetaString":
                if(element.getRegularLength()==0){
                    return this;
                }
            case "SingalMetaChar":
                regularList.add(element);
                OrSeparatorLocal.set(OrSeparatorLocal.size()-1,regularList.size());
        }
        last=element;

        return this;
    }

    @Override
    public void setLength(LengthExpression l){
        this.length=l;
    }

    @Override
    public StringBuilder getString() {
        List<Regular> makeString=this.regularList;
        if(OrSeparatorLocal.size()!=2){
            int section= privateRandom.RandomInteger(0,OrSeparatorLocal.size());
            int start=OrSeparatorLocal.get(section)+1;
            int end=OrSeparatorLocal.get(section+1)-1;
            makeString=regularList.subList(start,end);
        }

        int Stringlength=length.getReplaceNum();
        StringBuilder sb=new StringBuilder();
        for(int loop=0;loop<Stringlength;loop++) {
            for(Regular r:makeString){
                sb.append(r.getString());
            }
        }
        return sb;
    }

    @Override
    public int getRegularLength() {
        return regularList.size();
    }

    @Override
    public String getString(Object... option) {
        return getString().insert(0,'\'').append('\'').toString();
    }
}
