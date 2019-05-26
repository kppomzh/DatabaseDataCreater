package Exception.RegularException;

import CreateSQLParser.Lex.Word;

public class NullBracketException extends BaseException {
    public NullBracketException(Word word) {
        super(word);
        errMessage.append("正则表达式字符集合不能为空");
    }
}
