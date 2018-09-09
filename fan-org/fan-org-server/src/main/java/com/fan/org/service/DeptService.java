package com.fan.org.service;

import com.fan.org.dto.DeptDTO;
import com.fan.org.entity.Dept;
import org.springframework.data.domain.Page;

import java.util.List;

public interface DeptService {
    Dept add(DeptDTO dto);
    void deleteById(Integer deptId);
    void update(DeptDTO dto);
    void updateByDeptCode(DeptDTO dto);
    Dept getById(Integer deptId);
    Dept getByDeptCode(String deptCode);
    List<Dept> findInDeptCodes(List<String> deptCodes);
    List<Dept> findInDeptIds(List<Integer> deptIds);
    Page<Dept> findPageByQuery();
}
