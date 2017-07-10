create database xy DEFAULT charset utf8;

use xy;

/*
管理员表
 */
create table admin(
  id int(11)  not null primary key auto_increment comment '管理员账号id',
  name varchar(30)  comment '用户名',
  pass varchar(30)  comment '用户密码',
  type int(1)  DEFAULT 0 comment '管理员账号类型',
  createTime VARCHAR(25) not null comment '创建时间',
  updateTime VARCHAR(25) not null  COMMENT '创建时间'
)  ENGINE = INNODB;

