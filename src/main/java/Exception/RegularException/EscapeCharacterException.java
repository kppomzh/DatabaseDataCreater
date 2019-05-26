package Exception.RegularException;

import CreateSQLParser.Lex.Word;

public class EscapeCharacterException extends BaseException {
    public EscapeCharacterException(Word word,String message) {
        super(word);
        super.errMessage.append(message);
    }
}
