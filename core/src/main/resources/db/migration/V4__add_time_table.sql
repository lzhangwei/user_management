ALTER TABLE customer_arrangement DROP COLUMN DATE;
rename table customer_arrangement to course_customer_relationship;

CREATE TABLE time (
  id INT AUTO_INCREMENT PRIMARY KEY ,
  course_customer_id int,
  FOREIGN KEY (course_customer_id) REFERENCES course_customer_relationship(id)
);