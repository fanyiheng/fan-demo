#创建数据库
create database if not exists fan_org default charset utf8 collate utf8_bin;

#创建部门表
create table if not exists t_dept(
  dept_id int unsigned primary key auto_increment,
  dept_name varchar(128) not null ,
  dept_code varchar(32) not null ,
  p_code varchar(32) not null default '0' comment '父编码',
  p_code_seq varchar(512) not null default '0' comment  '父编码序列，用/隔开',
  deleted tinyint unsigned not null default '0' comment '是否删除，0 否 1 是',
  create_time timestamp not null default current_timestamp comment '创建时间',
  update_time timestamp not null default current_timestamp on update current_timestamp comment '修改时间'
) engine InnoDB;
#创建索引
create index idx_dept_name on t_dept(dept_name);
create index idx_dept_code on t_dept(dept_code);

#创建用户表
create table if not exists t_user(
  user_id int unsigned auto_increment,
  user_name varchar(128) not null ,
  user_code varchar(32) not null ,
  deleted tinyint unsigned not null default '0' comment '是否删除，0 否 1 是',
  create_time timestamp not null default current_timestamp comment '创建时间',
  update_time timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
  primary key (user_id),
  key idx_user_name (user_name),
  key idx_user_code(user_code)
) engine InnoDB;
