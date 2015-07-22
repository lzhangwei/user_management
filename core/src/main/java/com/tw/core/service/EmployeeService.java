package com.tw.core.service;

import com.tw.core.dao.EmployeeDao;
import com.tw.core.entity.Coach;
import com.tw.core.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public List<Coach> getAllCoach() {
        return employeeDao.getAllCoach();
    }

    public List<Employee> getAllEmployee() {

        return employeeDao.getAllEmployee();

    }

    public void deleteEmployee(int id) {
        employeeDao.deleteEmployee(new Employee(id));
    }

    public Employee getEmployeeById(int id) {
        return employeeDao.getEmployeeById(id);
    }

    public void addEmployee(Employee employee) {
        employeeDao.addEmployee(employee);
    }

    public void updateEmployee(Employee employee) {
        employeeDao.updateEmployee(employee);
    }
}
