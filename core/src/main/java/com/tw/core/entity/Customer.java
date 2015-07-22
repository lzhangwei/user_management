package com.tw.core.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "coach_id")
    private Coach coach;

    @ManyToMany(targetEntity = Course.class,fetch=FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinTable(
            name="course_customer_date", //中间表的表名
            joinColumns={@JoinColumn(name="customer_id")}, //设置自己方的主键名
            inverseJoinColumns={@JoinColumn(name="course_id")} //设置对方的主键名
    )
    private Set<Course> courses;

    public Customer() {
    }

    public Customer(String name, Coach coach, Set<Course> courses) {
        this.name = name;
        this.coach = coach;
        this.courses = courses;
    }

    public Customer(String name, Coach coach) {
        this.name = name;
        this.coach = coach;
    }

    public Customer(int id, String name, Coach coach) {
        this.id = id;
        this.name = name;
        this.coach = coach;
    }

    public Customer(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public void addCourse(Course course) {
        this.courses.add(course);
    }
}
