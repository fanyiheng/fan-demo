package com.fan.org.dto;

import com.fan.org.entity.BaseEntity;
import lombok.Data;

@Data
public class DeptDTO extends BaseEntity {
    private Integer deptId;
    private String deptCode;
    private String deptName;
    /**父编码*/
    private String pCode;
    /**父编码系列，用/隔开*/
    private String pCodeSeq;
}
