package com.zhzm.exceptions;

public class TableStrucDataException extends BaseException {
    public TableStrucDataException(String word) {
        super();
        errMessage.append(word);
    }
}
