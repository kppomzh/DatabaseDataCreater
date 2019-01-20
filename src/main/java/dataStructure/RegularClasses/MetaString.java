package dataStructure.RegularClasses;

import Utils.privateRandom;
import dataStructure.KVEntryImpl;

import java.util.ArrayList;
import java.util.List;

public class MetaString implements Regular {
    private ArrayList<Regular> regularList;
    private ArrayList<Integer> OrSeparatorLocal;
    private LengthExpression length;
    private Regular last=new OrSeparator();

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

    public MetaString addElement(Regular element){
        switch(element.getRealName()){
            //元字符串长度不进入列表
            case "LengthExpression":
                if(last.getRealName().equals("MetaString")||
                    last.getRealName().equals("BracketExpression")||
                    last.getRealName().equals("NmetaString")||
                    last.getRealName().equals("SingalMetaChar")){
                    last.setLength((LengthExpression) element);
                }
                break;
            case "OrSeparator":
                OrSeparatorLocal.add(OrSeparatorLocal.size()-1,regularList.size());
            case "MetaString":
            case "SingalMetaChar":
            case "BracketExpression":
            case "NmetaString":
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
    public String getGeneratedString() {
        List<Regular> makeString=this.regularList;
        if(OrSeparatorLocal.size()!=2){
            int section= privateRandom.RandomNumber(0,OrSeparatorLocal.size()).intValue();
            int start=OrSeparatorLocal.get(section)+1;
            int end=OrSeparatorLocal.get(section+1)-1;
            makeString=regularList.subList(start,end);
        }

        int Stringlength=length.getReplaceNum();
        StringBuilder sb=new StringBuilder();
        for(int loop=0;loop<Stringlength;loop++)
            for(Regular r:makeString){
                sb.append(r.getGeneratedString());
            }
        return sb.toString();
    }
}
