package com.zhzm.exceptions.regular;

public class EscapeCharacterException extends RegularBaseException{
    public EscapeCharacterException(String partRegular, int list) {
        super(partRegular, list);
        super.partRegular.append("非法的转义字符");
    }
}
