package CreateSQLParser.Plan;

import CreateSQLParser.Lex.Word;
import dataStructure.RegularClasses.Regular;
import dataStructure.TableStructure;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class InsertPlanMaker {
    int[] range;
    double[] numberarea;
    boolean rangeEnd , isDefault , isSingal,
            setInline , isUnmake , isRegular,isStringType;
    int arraylocal, na;
    List<String> inlineObject;
    Regular regular;
    String listname , type , defaultDataType , defaultStr ;

    public TableStructure makeStrusture(List<Word> words) throws Exception {
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
                        throw new Exception("多单词关键字：not null必须连用。");
                    break;
                case "primary":
                    if (!iwords.next().getName().equals("key"))
                        throw new Exception("多单词关键字：primary key必须连用。");
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
                    numberarea[na] = Double.valueOf(w.getSubstance());
                    na++;
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
                        throw new Exception("正则表达式有未结束的子表达式。");
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
                        if (numberarea[0] > numberarea[1])
                            throw new Exception("数值型设定范围必须由小到大。");
                        structure.addlist(listname, type,
                                defaultDataType, isSingal, isDefault,isStringType, defaultStr,
                                range, numberarea, inlineObject, isUnmake, isRegular,
                                regular);
                        init();
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
        numberarea = new double[2];
        regular=null;
        inlineObject = new LinkedList<>();
        listname = null; type = "string"; defaultDataType = ""; defaultStr = null;
        rangeEnd = false; isDefault = false; isSingal = false;
        setInline = false; isUnmake = false; isRegular = false;isStringType=false;
    }
}
