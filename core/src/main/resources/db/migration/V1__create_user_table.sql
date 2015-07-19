DROP TABLE IF EXISTS users ;

CREATE TABLE users(
  id int auto_increment primary key,
  name varchar(20) NOT NULL,
  gender varchar(10),
  email varchar(50),
  age int
);

insert into users values (null,'张三','男','aaa@qq.com',12);
insert into users values (null,'李四','男','bbb@qq.com',15);
insert into users values (null,'王五','男','ccc@qq.com',14);