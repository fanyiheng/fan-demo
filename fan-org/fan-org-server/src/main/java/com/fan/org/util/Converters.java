package com.fan.org.util;

import com.fan.org.exception.FanException;
import com.fan.org.exception.FanExceptions;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 对象转换工具
 */
public class Converters {
    public static <R,T> List<T> convertList(List<R> source,Class<T> targetClass){
        if(CollectionUtils.isEmpty(source))return null;
        return source.stream().map(e->convertObj(e,targetClass)).collect(Collectors.toList());
    }
    public static <R,T> T convertObj(@NotNull R source, Class<T> targetClass){
        try {
            T target = targetClass.newInstance();
            BeanUtils.copyProperties(source,target);
            return target;
        }catch (Exception e){
            throw FanExceptions.CONVERT_EX;
        }
    }
}
