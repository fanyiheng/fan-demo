package com.fan.org.repository;

import com.fan.org.entity.Dept;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeptRepository extends JpaRepository<Dept,Integer> {
    Dept getByDeptCode(String deptCode);

}
