package com.tw.core.dao;

import com.tw.core.entity.Customer;
import com.tw.core.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDao {

    public Customer getCustomerById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createSQLQuery("select * from customer WHERE id = " + id).addEntity(Customer.class);
        List<Customer> customers = query.list();
        session.close();
        return customers.get(0);
    }

    public void updateCustomer(Customer customer) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(customer);
        session.getTransaction().commit();
        session.close();
    }

    public List<Customer> getAllCustomer() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createSQLQuery("select * from customer").addEntity(Customer.class);
        List<Customer> customers = query.list();
        session.close();
        return customers;
    }

    public void addCustomer(Customer customer) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(customer);
        session.getTransaction().commit();
        session.close();
    }

    public void deleteCustomer(Customer customer) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(customer);
        session.getTransaction().commit();
        session.close();
    }

}
