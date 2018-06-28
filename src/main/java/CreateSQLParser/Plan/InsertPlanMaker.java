package CreateSQLParser.Plan;

import CreateSQLParser.Lex.Word;
import dataStruture.TableStructure;

import java.util.Iterator;
import java.util.List;

public class InsertPlanMaker {
    public TableStructure makeStrusture(List<Word> words) throws Exception {
        TableStructure structure=new TableStructure();

        Iterator<Word> iwords=words.iterator();
        int[] range=new int[10];
        boolean rangeEnd=false,isDefault=false,isSingal=false;
        int arraylocal=0;
        String listname = null,type="string",defaultDataType="",defaultStr=null;

        for (; iwords.hasNext(); ) {
            Word w = iwords.next();
            switch (w.getName()) {
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
                case "defaultdatatype":
                    defaultDataType=w.getSubstance();
                case ")":
                    if (rangeEnd)
                        rangeEnd = false;
                    break;
                case ";":
                case ",":
                    if (!rangeEnd) {
                        structure.addlist(listname,type,defaultDataType,isSingal,isDefault,defaultStr,range);
                        arraylocal = 0;
                        range = new int[10];
                        defaultDataType="";
                        isSingal=false;
                        isDefault=false;
                    }
                    break;
            }
        }
        return structure;
    }
}
