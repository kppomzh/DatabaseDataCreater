package Exception.RegularException;

import CreateSQLParser.Lex.Word;

public abstract class BaseException extends Exception {
    protected StringBuilder errMessage;
    public BaseException(Word word){
        errMessage=new StringBuilder();
        errMessage.append(word.getSubstance());
        errMessage.append(" at line:");
        errMessage.append(word.getLine());
        errMessage.append(",list:");
        errMessage.append(word.getList());
        errMessage.append("  ");
    }

    @Override
    public String getMessage(){
        return errMessage.toString();
    }
}
