ALTER TABLE course_customer_relationship ADD date DATE NOT NULL;
rename table course_customer_relationship to course_customer_date;

alter table arrangement drop FOREIGN KEY arrangement_ibfk_1;
drop table arrangement;