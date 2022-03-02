package com.zhzm.exceptions;

public class NetworkSendError extends Exception{
    public NetworkSendError(int type){
        super(getMessage(type));
    }

    private static String getMessage(int type){
        switch(type){
            case -1:
                return "接收信息小于消息头长度";
            case -2:
                return "接收信息无分隔符";
            case -3:
            default:
                return "接收信息与预计长度不符";
        }
    }
}
