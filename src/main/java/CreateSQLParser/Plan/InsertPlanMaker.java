package CreateSQLParser.Plan;

import CreateSQLParser.Lex.Word;
import Exception.DataException.TableStrucDataException;
import Exception.TypeException.CompareException;
import Exception.TypeException.MultiKeywordException;
import Exception.TypeException.RegularinPlanException;
import DataCreater.RegularCreater.Regular;
import Utils.Factorys.TypeCreaterFactory;
import dataStructure.ListStructure;
import dataStructure.TableStructure;
import Exception.BaseException;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class InsertPlanMaker {
    int[] range;
    String[] numberarea;
    boolean rangeEnd , isDefault , isSingal,hasArray=false,
            setInline , isUnmake , isRegular,isStringType,isPrimary;
    int arraylocal, na;
    List<String> inlineObject;
    Word regular;
    String listname , type , defaultDataType , defaultStr ;

    public TableStructure makeStrusture(List<Word> words) throws BaseException, TableStrucDataException {
        TableStructure structure = new TableStructure();

        Iterator<Word> iwords = words.iterator();
        init();

        for (; iwords.hasNext(); ) {
            Word w = iwords.next();
            switch (w.getName()) {
                case "inline":
                    inlineObject.add(w.getSubstance());
                    break;
                case "not":
                    if (!iwords.next().getName().equals("null"))
                        throw new MultiKeywordException(w,"多单词关键字：not null必须连用。");
                    break;
                case "primary":
                    if (!iwords.next().getName().equals("key"))
                        throw new MultiKeywordException(w,"多单词关键字：primary key必须连用。");
                    isPrimary = true;
                    break;
                case "unique":
                    isSingal = true;
                    break;
                case "tablename":
                    structure.setTbname(w.getSubstance());
                    break;
                case "listname":
                    listname = w.getSubstance();
                    break;
                case "type":
                    type = w.getSubstance();
                    break;
                case "range":
                    rangeEnd = true;
                    range[arraylocal] = Integer.valueOf(w.getSubstance());
                    arraylocal++;
                    break;
                case "defaultStr":
                    isDefault = true;
                    defaultStr = w.getSubstance();
                    break;
                case "numberange":
                    numberarea[na] = w.getSubstance();
                    na++;
                    hasArray=na==2;
                    break;
                case "unmake":
                    isUnmake = true;
                    break;
                case "isRegular":
                    isRegular = true;
                    regular = w;
                    break;
                case "defaultdatatype":
                    isStringType=true;
                    defaultDataType = w.getSubstance();
                    break;
                case ")":
                    if (rangeEnd)
                        rangeEnd = false;
                    break;
                case ";":
                case ",":
                    if (!(rangeEnd || setInline)) {
                        if (hasArray&&new BigDecimal(numberarea[0]).compareTo(new BigDecimal(numberarea[1]))==1)
                            throw new CompareException(w,"数值型设定范围必须由小到大。");
                        else if(type.equals("int")&&range[1]!=0){
                            throw new CompareException(w,"整型数不能有小数范围的定义。");
                        }
                        else {
                            ListStructure structurel=new ListStructure(listname,type);

                            structurel.setAdvancedType(defaultDataType,isStringType);
                            structurel.setRange(range);
                            structurel.setNumberarea(numberarea);
                            if(isRegular)
                                structurel.setRegularStr(regular);
                            if (inlineObject.size() != 0)
                                structurel.setInlineObject(inlineObject.toArray(new String[0]));
                            structurel.setUnmake(isUnmake);
                            if(isDefault)
                                structurel.setDefaultStr(defaultStr);
                            structurel.setPrimary(isPrimary);
                            //singal一定放在最后在设置，内部会有特性的冲突检查，如果存在default或者inline的话会屏蔽这两种特性
                            structurel.setSingal(isSingal);

                            structurel.setCreater(TypeCreaterFactory.getTypeCreater(structurel));
                            structure.addList(structurel);
                            init();
                        }
                    }
                    break;
                case "{":
                    setInline = true;
                    break;
                case "}":
                    setInline = false;
                    break;
            }
        }
        return structure;
    }

    private void init(){
        range = new int[10];
        arraylocal = 0; na = 0;
        numberarea = new String[2];
        regular=null;
        inlineObject = new LinkedList<>();
        listname = null; type = "string"; defaultDataType = ""; defaultStr = null;
        rangeEnd = false; isDefault = false; isSingal = false;hasArray=false;
        setInline = false; isUnmake = false; isRegular = false;isStringType=false;
        isPrimary=false;
    }
}
