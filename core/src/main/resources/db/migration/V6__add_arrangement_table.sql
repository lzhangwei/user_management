alter table time drop FOREIGN KEY time_ibfk_1;
drop table time;

CREATE TABLE arrangement (
  id INT AUTO_INCREMENT PRIMARY KEY ,
  course_id int,
  FOREIGN KEY (course_id) REFERENCES course(id)
);