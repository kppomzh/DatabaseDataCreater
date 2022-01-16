package com.zhzm.exceptions.regular;

public class BucketFiledException extends RegularBaseException{
    public BucketFiledException(String partRegular, int list) {
        super(partRegular, list);
    }
}
