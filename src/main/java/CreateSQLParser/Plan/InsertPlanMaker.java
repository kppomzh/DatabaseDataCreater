package CreateSQLParser.Plan;

import CreateSQLParser.Lex.Word;
import Exception.DataException.TableStrucDataException;
import Exception.TypeException.CompareException;
import Exception.TypeException.MultiKeywordException;
import Exception.TypeException.RegularinPlanException;
import DataCreater.RegularCreater.Regular;
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
    Regular regular;
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
                    try {
                        regular = RegularPlanMaker.makeRegular(w);
                    }
                    catch (StringIndexOutOfBoundsException e){
                        throw new RegularinPlanException(w,"正则表达式有未结束的子表达式。");
                    }
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
                            structure.addlist(listname, type, defaultDataType, isSingal, isDefault, isStringType, defaultStr, range, numberarea, inlineObject, isUnmake, isRegular, regular, isPrimary);
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
