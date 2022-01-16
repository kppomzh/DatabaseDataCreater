package com.zhzm.exceptions.regular;

public class NullBracketException extends RegularBaseException{
    public NullBracketException(String partRegular, int line, int list) {
        super(partRegular, line, list);
    }
}
