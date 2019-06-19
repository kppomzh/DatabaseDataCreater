package Exception.TypeException;

import CreateSQLParser.Lex.Word;
import Exception.BaseException;

public class MultiKeywordException extends BaseException {
    public MultiKeywordException(Word word,String message) {
        super(word);
        errMessage.append(message);
    }
}
