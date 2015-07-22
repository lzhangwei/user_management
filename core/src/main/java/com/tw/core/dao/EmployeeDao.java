package com.tw.core.dao;

import com.tw.core.entity.Coach;
import com.tw.core.entity.Employee;
import com.tw.core.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDao {

    public void updateEmployee(Employee employee) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(employee);
        session.getTransaction().commit();
        session.close();
    }

    public List<Employee> getAllEmployee() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createSQLQuery("select * from employee").addEntity(Employee.class);
        List<Employee> employees = query.list();
        session.close();
        return employees;
    }

    public List<Coach> getAllCoach() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createSQLQuery("select * from employee WHERE role='coach'").addEntity(Coach.class);
        List<Coach> coaches = query.list();
        session.close();
        return coaches;
    }

    public void addEmployee(Employee employee) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(employee);
        session.getTransaction().commit();
        session.close();
    }

    public void deleteEmployee(Employee employee) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(employee);
        session.getTransaction().commit();
        session.close();
    }

    public Employee getEmployeeById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createSQLQuery("select * from employee WHERE id = " + id).addEntity(Employee.class);
        List<Employee> employees = query.list();
        session.close();
        return employees.get(0);
    }
}
