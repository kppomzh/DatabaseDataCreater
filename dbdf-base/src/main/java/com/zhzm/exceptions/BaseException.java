package com.zhzm.exceptions;

import com.zhzm.antlr.createParser;
import org.antlr.v4.runtime.IntStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.atn.ATNSimulator;

/**
 * @author Shimo Tsuki
 */
public abstract class BaseException extends RecognitionException {
    protected StringBuilder errMessage;

//    public BaseException(Word word) {
//        errMessage = new StringBuilder();
//        errMessage.append(word.getSubstance());
//        errMessage.append(" at line:");
//        errMessage.append(word.getLine());
//        errMessage.append(",list:");
//        errMessage.append(word.getList());
//        errMessage.append("  ");
//    }

    public BaseException(String message, createParser parser, IntStream stream, ParserRuleContext ctx) {
        super(parser,stream,ctx);
        errMessage = new StringBuilder(message);
    }

    public BaseException(){
        super(null,null,null);
        errMessage = new StringBuilder();
    }

    @Override
    public String getMessage() {
        return errMessage.toString();
    }
}
