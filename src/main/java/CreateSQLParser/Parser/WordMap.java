package CreateSQLParser.Parser;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 目前来看严格的语法检查似乎还不需要加入，直接在赋格的地方简单搞搞似乎也可以
 */
public abstract class WordMap {
    protected HashMap<String,ArrayList<String>> wordMap;
    public WordMap()
    {
        ArrayList<String> temp=new ArrayList<>(1);
        wordMap=new HashMap<>();
        wordMap.put("create",temp);
        wordMap.put("table",temp);
        wordMap.put("(",temp);
        wordMap.put(")",temp);
        wordMap.put(",",temp);
        wordMap.put("varchar",temp);
        wordMap.put("varchar2",temp);
        wordMap.put("char",temp);
        wordMap.put("nvarchar",temp);
        wordMap.put("number",temp);
        wordMap.put("int",temp);
        wordMap.put("integer",temp);
        wordMap.put("float",temp);
        wordMap.put("double",temp);
        wordMap.put("decimal",temp);
        wordMap.put("date",temp);
        wordMap.put("timestamp",temp);
        wordMap.put("boolean",temp);
        wordMap.put("not",temp);
        wordMap.put("unique",temp);
        wordMap.put("primark",temp);
        wordMap.put("key",temp);
        wordMap.put("stringtype",temp);
        wordMap.put(";",temp);
    }
}
