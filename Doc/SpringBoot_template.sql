
create database springboot_template_db character set utf8;
use springboot_template_db ;

drop table if exists user_tb;
create table user_db(
 id VARCHAR(32) PRIMARY KEY NOT NULL COMMENT '用户id',
 player_id VARCHAR(32) NOT NULL COMMENT '玩家id',
 user_name varchar (32) NOT NULL COMMENT '用户姓名',
 user_pwd varchar (32) NOT NULL COMMENT '用户密码'
);

drop table if exists base_db;
create table base_db(
id VARCHAR(32) PRIMARY KEY NOT NULL COMMENT 'id',

);


