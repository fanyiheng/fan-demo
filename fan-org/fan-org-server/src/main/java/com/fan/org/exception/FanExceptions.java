package com.fan.org.exception;

import com.fan.org.enums.ErrorEnum;

public class FanExceptions {
    /**ID为空异常*/
    public static final FanCoderException ID_IS_NULL = new FanCoderException(ErrorEnum.ID_IS_NULL);
    /**对象转换异常*/
    public static final FanCoderException CONVERT_EX = new FanCoderException(ErrorEnum.CONVERT_EX);
    /**对象不存在异常*/
    public static final FanCoderException OBJ_NOT_FOUNT = new FanCoderException(ErrorEnum.OBJ_NOT_FOUND);
}
