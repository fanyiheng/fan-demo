package com.fan.org.enums;

public enum ErrorEnum implements BaseEnum<String> {
    ID_IS_NULL("0000","ID 不能为空"),
    CONVERT_EX("0001","对象转换异常"),
    OBJ_NOT_FOUND("0002","对象不存在"),
    ;
    private ErrorEnum(String code, String msg){
        this.code = code;
        this.msg = msg;
    }
    private String code;
    private String msg;
    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return msg;
    }
}
