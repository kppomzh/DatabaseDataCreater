package Exception.RegularException;

import CreateSQLParser.Lex.Word;
import Exception.BaseException;

public class EscapeCharacterException extends BaseException {
    public EscapeCharacterException(Word word,String message) {
        super(word);
        super.errMessage.append(message);
    }
}
