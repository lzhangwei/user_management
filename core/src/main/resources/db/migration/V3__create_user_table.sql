CREATE TABLE employee (
  id INT AUTO_INCREMENT PRIMARY KEY ,
  name VARCHAR(50),
  role VARCHAR(20)
);

INSERT INTO employee VALUES (null, 'zhangsan', 'coach');
INSERT INTO employee VALUES (null, 'zhaoliu', 'coach');
INSERT INTO employee VALUES (null, 'lisi', 'hr');
INSERT INTO employee VALUES (null, 'wangwu', 'ops');

CREATE TABLE user (
  id INT AUTO_INCREMENT PRIMARY KEY ,
  name VARCHAR(50),
  password VARCHAR(50),
  employee_id INT,
  FOREIGN KEY (employee_id) REFERENCES employee(id)
);

INSERT INTO user VALUES (null, 'zhangsan', '123456', 1);
INSERT INTO user VALUES (null, 'zhaoliu', '123456', 2);
INSERT INTO user VALUES (null, 'lisi', '123456', 3);
INSERT INTO user VALUES (null, 'wangwu', '123456', 4);

CREATE TABLE customer (
  id INT AUTO_INCREMENT PRIMARY KEY ,
  name VARCHAR(50),
  coach_id INT,
  FOREIGN KEY (coach_id) REFERENCES employee(id)
);

INSERT INTO customer VALUES (null, "customer_1", 1);
INSERT INTO customer VALUES (null, "customer_2", 2);
INSERT INTO customer VALUES (null, "customer_3", 1);

CREATE TABLE course (
  id INT AUTO_INCREMENT PRIMARY KEY ,
  name VARCHAR(50),
  coach_id INT,
  FOREIGN KEY (coach_id) REFERENCES employee(id)
);

INSERT INTO course VALUES (null, "瑜伽", 1);
INSERT INTO course VALUES (null, "拳击", 2);

CREATE TABLE customer_arrangement (
  id INT AUTO_INCREMENT PRIMARY KEY ,
  course_id int,
  customer_id int,
  date DATE,
  FOREIGN KEY (course_id) REFERENCES course(id),
  FOREIGN KEY (customer_id) REFERENCES customer(id)
);

