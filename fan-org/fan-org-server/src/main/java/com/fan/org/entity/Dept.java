package com.fan.org.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity(name = "t_dept")
public class Dept extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer deptId;
    private String deptCode;
    private String deptName;
    /**父编码*/
    private String pCode;
    /**父编码系列，用/隔开*/
    private String pCodeSeq;
    private int deleted;
}
