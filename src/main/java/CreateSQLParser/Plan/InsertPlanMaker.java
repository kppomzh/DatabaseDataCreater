package CreateSQLParser.Plan;

import CreateSQLParser.Lex.Word;
import dataStruture.TableStructure;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class InsertPlanMaker {
    public TableStructure makeStrusture(List<Word> words) throws Exception {
        TableStructure structure=new TableStructure();

        Iterator<Word> iwords=words.iterator();
        int[] range=new int[10];
        double[] numberarea=new double[2];
        boolean rangeEnd=false,isDefault=false,isSingal=false,
                setInline=false,isUnmake=false;
        int arraylocal=0,na=0;
        List<String> inlineObject=new LinkedList<>();
        String listname = null,type="string",defaultDataType="",defaultStr=null;

        for (; iwords.hasNext(); ) {
            Word w = iwords.next();
            switch (w.getName()) {
                case "inline":
                    inlineObject.add(w.getSubstance());
                    break;
                case "not":
                    if(!iwords.next().getName().equals("null"))
                        throw new Exception("多单词关键字：not null必须连用。");
                    break;
                case "primary":
                    if(!iwords.next().getName().equals("key"))
                        throw new Exception("多单词关键字：primary key必须连用。");
                case "unique":
                    isSingal=true;
                    break;
                case "tablename":
                    structure.setTbname(w.getSubstance());
                    break;
                case "listname":
                    listname=w.getSubstance();
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
                    isDefault=true;
                    defaultStr=w.getSubstance();
                    break;
                case "numberange":
                    numberarea[na] = Double.valueOf(w.getSubstance());
                    na++;
                    break;
                case "unmake":
                    isUnmake=true;
                    break;
                case "defaultdatatype":
                    defaultDataType=w.getSubstance();
                case ")":
                    if (rangeEnd)
                        rangeEnd = false;
                    break;
                case ";":
                case ",":
                    if (!(rangeEnd || setInline)) {
                        if(numberarea[0]>numberarea[1])
                            throw new Exception("数值型设定范围必须由小到大。");
                        structure.addlist(listname,type,
                                defaultDataType,isSingal,isDefault,defaultStr,
                                range,numberarea,inlineObject,isUnmake);
                        arraylocal = 0;
                        na=0;
                        numberarea=new double[2];
                        range = new int[10];
                        defaultDataType="";
                        isSingal=false;
                        isDefault=false;
                        isUnmake=false;
                        inlineObject=new LinkedList<>();
                    }
                    break;
                case "{":
                    setInline=true;
                    break;
                case "}":
                    setInline=false;
                    break;
            }
        }
        return structure;
    }
}
