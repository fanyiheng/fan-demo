package com.fan.org.service.impl;

import com.fan.org.entity.User;
import com.fan.org.exception.FanException;
import com.fan.org.repository.DeptRepository;
import com.fan.org.dto.DeptDTO;
import com.fan.org.entity.Dept;
import com.fan.org.exception.FanExceptions;
import com.fan.org.service.DeptService;
import com.fan.org.util.Converters;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntFunction;

@Service
@Slf4j
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptRepository deptRepository;
    public static final String DEFAULT_P_CODE = "0";

    @Override
    public Dept add(DeptDTO dto) {
        Dept dept = Converters.convertObj(dto, Dept.class);
        Date curDate = new Date();
        dept.setCreateTime(curDate);
        dept.setUpdateTime(curDate);
        dept.setDeleted(0);
        if(!StringUtils.hasText(dept.getPCode())||!StringUtils.hasText(dept.getPCodeSeq())){
            dept.setPCode(DEFAULT_P_CODE);
            dept.setPCodeSeq(DEFAULT_P_CODE);
        }
        return deptRepository.save(dept);
    }

    @Override
    public void deleteById(Integer deptId) {
        Dept dept = deptRepository.getOne(deptId);
        if(dept!=null && dept.getDeleted() != 1){
            dept.setDeleted(1);
        }
        dept.setUpdateTime(new Date());
        deptRepository.save(dept);
    }

    @Override
    public void update(DeptDTO dto) {
        if(dto.getDeptId()==null){
            throw FanExceptions.ID_IS_NULL;
        }
        Dept dept = deptRepository.getOne(dto.getDeptId());
        if(dept == null){
            throw FanExceptions.OBJ_NOT_FOUNT;
        }
        Date cTime = dept.getCreateTime();
        BeanUtils.copyProperties(dto,dept);
        dept.setCreateTime(cTime);
        dept.setUpdateTime(new Date());
        deptRepository.save(dept);
    }

    @Override
    public void updateByDeptCode(DeptDTO dto) {
        Dept dept = getByDeptCode(dto.getDeptCode());
        if(dept == null){
            throw FanExceptions.OBJ_NOT_FOUNT;
        }
        Date cTime = dept.getCreateTime();
        BeanUtils.copyProperties(dto,dept);
        dept.setCreateTime(cTime);
        dept.setUpdateTime(new Date());
        deptRepository.save(dept);
    }

    @Override
    public Dept getById(Integer deptId) {
        return deptRepository.getOne(deptId);
    }

    @Override
    public Dept getByDeptCode(String deptCode) {
        if(!StringUtils.hasText(deptCode)) return null;
        return deptRepository.getByDeptCode(deptCode) ;
    }

    @Override
    public List<Dept> findInDeptIds(List<Integer> deptIds) {
        if(CollectionUtils.isEmpty(deptIds)) return Collections.emptyList();
        return null;
    }

    @Override
    public Page<Dept> findPageByQuery() {
        return null;
    }

    @Override
    public List<Dept> findInDeptCodes(List<String> deptCodes) {
        return null;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Method m = DeptServiceImpl.class.getMethod("ge",InClazz.class,String.class);
        Type[] genericParameterTypes = m.getGenericParameterTypes();
        Type genericReturnType = m.getGenericReturnType();
        Type[] bounds = ((TypeVariable) genericReturnType).getBounds();
        TypeVariable<Method>[] typeParameters = m.getTypeParameters();
        System.out.println(typeParameters[0].getName());
        System.out.println(Arrays.toString(bounds));
        System.out.println(genericReturnType);
        System.out.println(Arrays.toString(genericParameterTypes));
        System.out.println(DeptServiceImpl.class.getGenericSuperclass());
        System.out.println(InClazz.class);
    }

    public <T extends InClazz> T ge(T t,String s){
        return null;
    }

    public static void supplier(List<User> user,Consumer<String> sup){
        for (int i = 0; i < user.size(); i++) {
            User u1 = user.get(0);
            sup.accept(u1.getUserName());
        }
    }

    private class CdClazz{

    }
    public static class InClazz{
        public static final int i = 5;

        public void f1(){
            try {

                f2();
            }catch (Exception e){
                throw new FanException(e);
            }
        }

        public void f3(){
            try {

                f1();
            }catch (Exception e){
                throw new FanException(e);
            }
        }

        public void f2(){
            throw FanExceptions.OBJ_NOT_FOUNT;
        }

        public <T> T[] pair(IntFunction<T[]> sup, T ... ts){
            T[] arr = sup.apply(ts.length);
            System.arraycopy(ts,0,arr,0,ts.length);
            return arr;
        }

        public void f5(List<? super InClazz> l){

        }

    }
}
