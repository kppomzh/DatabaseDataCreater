package CreateSQLParser.Parser;

import CreateSQLParser.Lex.Word;
import SavingTypeString.DataType;
import SavingTypeString.stringType;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Fugue {
    Set<String> mark;
    Set<String> data;
    Set<String> multi;
    public void init()
    {
        mark=new HashSet<>();
        mark.add("create");
        mark.add("table");
        mark.add("(");
        mark.add(")");
        mark.add(",");
        mark.add("null");
        mark.add("default");
        mark.add("key");
        mark.add("unique");
        mark.add("stringtype");
        mark.add(";");

        data=DataType.getTypeKeySet();

        multi=new HashSet<>();
        multi.add("not");
        multi.add("primary");
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
        Word w=words.get(0),last;
        for (int loop=0; iwords.hasNext();loop++) {
            last=w;
            w = iwords.next();
            if(data.contains(w.getName()))
            {
                w.setSubstance(DataType.getDataTypeString(w.getName()));
                w.setName("type");
            }
            else if(multi.contains(w.getName())){
//                switch(w.getName()){
//                    case "not":
//                        if(iwords.next().getName().equals("null"))
//
//                        break;
//                    case "primary":
//                        if(iwords.next().getName().equals("key"))
//
//                        break;
//                }
                continue;
            }
            else if(mark.contains(w.getName())){
                continue;
            }
            else{
                if(checknumber(w.getName())) {
                    w.setSubstance(w.getName());
                    if(last.getName().equals("default")){
                        w.setName("defaultStr");
                    }
                    else
                        w.setName("range");
                }
                else switch (last.getName()) {
                    case "table":
                        if(!w.getName().equals("String"))
                            w.setSubstance(w.getName());
                        w.setName("tablename");
                        break;
                    case "(":
                    case ",":
                        if(!w.getName().equals("String"))
                            w.setSubstance(w.getName());
                        w.setName("listname");
                        break;
                    case "default":
//                        w.setSubstance(w.getName());
                        w.setName("defaultStr");
                        break;
                    case "stringtype":
                        w.setSubstance(w.getName());
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
