package Exception.TypeException;

import CreateSQLParser.Lex.Word;
import Exception.BaseException;
public class RegularinPlanException extends BaseException {
    public RegularinPlanException(Word word,String message) {
        super(word);
        errMessage.append(message);
    }
}
