package Exception.RegularException;

import CreateSQLParser.Lex.Word;
import Exception.BaseException;

public class BucketFiledException extends BaseException {

    public BucketFiledException(Word word,String message){
        super(word);
        errMessage.append(message);
        errMessage.append(":正则表达式的字符范围必须由小到大。");
    }
}
