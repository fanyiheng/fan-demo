package com.fan.org.exception;

import com.fan.org.enums.BaseEnum;

public class FanCoderException extends FanException implements BaseEnum<Object>{
    private BaseEnum<?> exceptionCoder;

    public FanCoderException(BaseEnum<?> exceptionCoder){
        super(exceptionCoder.getMessage());
        this.exceptionCoder=exceptionCoder;
    }

    @Override
    public Object getCode() {
        return exceptionCoder.getCode();
    }

}
