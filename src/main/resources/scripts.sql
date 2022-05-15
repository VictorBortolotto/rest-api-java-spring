create database my_first_web_application;
use my_first_web_application;
create table user (
  id int primary key auto_increment,
  name varchar(450) not null,
  age int not null,
  email varchar(450) not null
);