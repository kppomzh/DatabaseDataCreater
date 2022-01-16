package com.zhzm.exceptions.regular;

public class RegularBaseException extends Exception{
    protected StringBuilder partRegular;
    private int list;
    public RegularBaseException(String partRegular,int list){
        this.partRegular = new StringBuilder(partRegular);
        this.list = list;
    }

    public String getMessage(){
        return "At line "+list+","+partRegular+" is an error Regular part.";
    }
}
