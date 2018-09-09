package com.fan.org.repository;

import com.fan.org.FanOrgServerApplicationTests;
import com.fan.org.entity.Dept;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


public class DeptRepositoryTest extends FanOrgServerApplicationTests {

    @Autowired
    private DeptRepository deptRepository;

    @Test
    public void save(){
        Dept dept = new Dept();
        dept.setDeptCode("test");
        dept.setDeptName("测试");
        dept.setPCode("0");
        dept.setPCodeSeq("0");
        dept.setDeleted(0);
        deptRepository.save(dept);
    }

    @Test
    @Transactional
    public void get(){
        Dept dept = deptRepository.getOne(1);
        System.out.println(dept);
    }
}