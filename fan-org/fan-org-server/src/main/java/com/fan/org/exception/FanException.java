package com.fan.org.exception;

public class FanException extends RuntimeException{

    public FanException(){}

    public FanException(String msg, Throwable e){
        super(msg,e);
    }
    public FanException(String msg){
        super(msg);
    }
    public FanException(Throwable e){
        super(e);
    }
}
