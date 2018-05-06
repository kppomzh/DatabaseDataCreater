package CreateSQLParser.Parser;

import CreateSQLParser.Lex.Word;
import dataStruture.TableStructure;

import java.util.Iterator;
import java.util.List;

public class Parser {
    public TableStructure makeStrusture(List<Word> words)
    {
        TableStructure structure=new TableStructure();

        Iterator<Word> iwords=words.iterator();
        int[] range=new int[10];
        boolean rangeEnd=false;
        int arraylocal=0;
        String listname,type="string";

        for (; iwords.hasNext(); ) {
            Word w = iwords.next();
            switch (w.getName()) {
                case "tablename":
                    structure.setTbname(w.getSubstance());
                    break;
                case "type":
                    type = w.getSubstance();
                    break;
                case "range":
                    rangeEnd = true;
                    range[arraylocal] = Integer.valueOf(w.getSubstance());
                    arraylocal++;
                    break;
                case ")":
                    if (rangeEnd)
                        rangeEnd = false;
                    break;
                case ";":
                case ",":
                    if (!rangeEnd) {
                        structure.addlist(type, false, false, range);
                        arraylocal = 0;
                        range = new int[10];
                    }
                    break;
            }
        }
        return structure;
    }
}
