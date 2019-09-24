package Exception.RegularException;

import CreateSQLParser.Lex.Word;
import Exception.BaseException;

public class NullMetaStringException extends BaseException {
    public NullMetaStringException(Word word) {
        super(word);
        errMessage.append("正则表达式元字符串不能为空");
    }
}
