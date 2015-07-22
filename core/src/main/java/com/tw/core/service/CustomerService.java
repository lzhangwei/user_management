package com.tw.core.service;

import com.tw.core.dao.CustomerDao;
import com.tw.core.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;

    public List<Customer> getAllCustomer() {
        return customerDao.getAllCustomer();
    }

    public void updateCustomer(Customer customer) {
        customerDao.updateCustomer(customer);
    }

    public void addCustomer(Customer customer) {
        customerDao.addCustomer(customer);
    }

    public void deleteCustomer(int id) {
        Customer customer = new Customer(id);
        customerDao.deleteCustomer(customer);
    }

    public Customer getCustomerById(int id) {
        return customerDao.getCustomerById(id);
    }
}
