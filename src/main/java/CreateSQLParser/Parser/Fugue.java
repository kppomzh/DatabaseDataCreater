package CreateSQLParser.Parser;

import CreateSQLParser.Lex.Word;
import SavingTypeString.DataType;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class Fugue {
    HashSet<String> mark;
    public void init()
    {
        mark=new HashSet<>();
        mark.add("create");
        mark.add("table");
        mark.add("(");
        mark.add(")");
        mark.add(",");
        mark.add("varchar");
        mark.add("varchar2");
        mark.add("char");
        mark.add("nvarchar");
        mark.add("number");
        mark.add("int");
        mark.add("decimal");
        mark.add("date");
        mark.add("timestamp");
        mark.add("not");
        mark.add("null");
        mark.add("stringtype");
        mark.add(";");
    }
    public Fugue()
    {
        init();
    }

    public List<Word> fugue(List<Word> words)
    {
        if(!words.get(0).getName().equals("create"))
            throw new RuntimeException("not start with create");

        Iterator<Word> iwords=words.iterator();
        Word w,last = words.get(0);
        for (int loop=0; iwords.hasNext();loop++,last=w) {
            w = iwords.next();
            if(mark.contains(w.getName()))
            {
                String dt=DataType.getDataTypeString(w.getName());
                if(dt!=null){
                    w.setName("type");
                    w.setSubstance(dt);
                }
            }
            else{
                w.setSubstance(w.getName());
                if(checknumber(w.getName())) {
                    w.setName("range");
                }
                else switch (last.getName()) {
                    case "table":
                        w.setName("tablename");
                        break;
                    case "(":
                    case ",":
                        w.setName("listname");
                        break;
                    case "stringtype":
                        w.setName("defaultdatatype");
                        break;
                    default:
                        break;
                }
            }
        }
        return words;
    }

    private boolean checknumber(String s)
    {
        for(char c:s.toCharArray())
            if(c<48||c>57)
                return false;
        return true;
    }
}
