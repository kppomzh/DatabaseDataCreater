package Exception.RegularException;

import CreateSQLParser.Lex.Word;

public class LengthDefineException extends BaseException {
    public LengthDefineException(Word word,String message) {
        super(word);
        errMessage.append(message);
    }
}
