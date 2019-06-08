package Exception.RegularException;

import CreateSQLParser.Lex.Word;

public class NullEndpointException extends BaseException {
    public NullEndpointException(Word word) {
        super(word);
        errMessage.append(word.getSubstance());
        errMessage.append("没有对应的终结符号");
    }
}
