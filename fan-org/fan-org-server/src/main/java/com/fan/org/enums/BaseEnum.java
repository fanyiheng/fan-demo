package com.fan.org.enums;

public interface BaseEnum<T> {
    T getCode();
    String getMessage();

    static <E extends BaseEnum<T>,T> E fromCode(T code,Class<E> clazz){
        if(code!=null) {
            E[] enumConstants = clazz.getEnumConstants();
            if (enumConstants != null && enumConstants.length > 0) {
                for (E e : enumConstants) {
                    if (e.getCode().equals(code))
                        return e;
                }
            }
        }
        return null;
    }
    static <E extends BaseEnum<T>,T> boolean contains(T code,Class<E> clazz){
        return fromCode(code, clazz) == null ? false : true;
    }
}
