package Exception.TypeException;

import CreateSQLParser.Lex.Word;
import Exception.BaseException;

public class CompareException extends BaseException {
    public CompareException(Word word,String message) {
        super(word);
        errMessage.append(message);
    }
}
