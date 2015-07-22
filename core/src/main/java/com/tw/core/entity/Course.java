package com.tw.core.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "coach_id")
    private Coach coach;

    @ManyToMany(targetEntity = Customer.class,fetch=FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinTable(
            name="course_customer_date", //中间表的表名
            joinColumns={@JoinColumn(name="course_id")}, //设置自己方的主键名
            inverseJoinColumns={@JoinColumn(name="customer_id")} //设置对方的主键名
    )
    private Set<Customer> customers;

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

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }
}
