package com.tw.core.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "employee")
public class Coach {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="coach_id")
    private Set<Customer> customers;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="coach_id")
    private Set<Course> courses;
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

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
