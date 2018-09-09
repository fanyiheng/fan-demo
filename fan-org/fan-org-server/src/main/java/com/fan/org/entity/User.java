package com.fan.org.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "t_user")
public class User extends BaseEntity{
    private String userId;
    private String userName;
    private String userCode;
    private int deleted;
}
