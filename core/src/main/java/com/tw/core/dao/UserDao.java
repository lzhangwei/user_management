package com.tw.core.dao;

import com.tw.core.entity.Coach;
import com.tw.core.entity.Course;
import com.tw.core.entity.Customer;
import com.tw.core.entity.User;
import com.tw.core.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Repository
public class UserDao {

    public int login(String name, String password) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Query query = session.createSQLQuery("select * from user WHERE name = '" + name +"' and password = '" + password + "'").addEntity(User.class);
        List<User> users = query.list();

        session.close();

        return users.size() > 0 ? users.get(0).getId() : 0;
    }

    public Coach getCoachById(int userId) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Query query = session.createSQLQuery("select * from employee where role='coach' and id = " + userId).addEntity(Coach.class);
        List<Coach> coaches = query.list();
        session.close();
        return coaches.get(0);
    }

    public List<Customer> getCustomersByCoachId(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Query query = session.createSQLQuery("select * from coach where id = " + id).addEntity(Coach.class);
        List<Coach> coaches = query.list();

        Set<Customer> customers = coaches.get(0).getCustomers();

        List<Customer> customerList = new ArrayList<Customer>(customers);

        session.close();

        return customerList;
    }

    public Course getCourseById(int id) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Query query = session.createSQLQuery("select * from course where id = 1").addEntity(Course.class);
        List<Course> courses = query.list();

        session.close();

        return courses.get(0);

    }

    public List<Coach> getCoaches() {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Query query = session.createSQLQuery("select * from employee where role = 'coach'").addEntity(Coach.class);
        List<Coach> coaches = query.list();

        session.close();

        return coaches;

    }

    public List<User> getUsers() {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Query query = session.createSQLQuery("select * from user").addEntity(User.class);
        List<User> users = query.list();

        session.close();

        return users;
    }

    public void addUser(User user) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        session.save(user);

        session.getTransaction().commit();

        session.close();

    }

    public void deleteUser(int id) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        User user = new User();
        user.setId(id);

        session.delete(user);

        session.getTransaction().commit();

        session.close();

    }

    public void updateUser(User user) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        session.update(user);

        session.getTransaction().commit();

        session.close();

    }

    public User getUserById(int userId) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Query query = session.createSQLQuery("select * from user WHERE id = " + userId).addEntity(User.class);
        List<User> users = query.list();

        session.close();

        return users.get(0);
    }

}
