package Exception.RegularException;

import CreateSQLParser.Lex.Word;

public class DoubleOrSeparatorException extends BaseException {
    public DoubleOrSeparatorException(Word word) {
        super(word);
        errMessage.append("不允许两个'|'连续出现或者'|'单独出现在首尾。");
    }
}
