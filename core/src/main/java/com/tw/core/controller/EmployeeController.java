package com.tw.core.controller;

import com.tw.core.entity.Employee;
import com.tw.core.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public ModelAndView employeeList() {

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("employees", employeeService.getAllEmployee());
        modelAndView.setViewName("employees");
        return modelAndView;

    }

    @RequestMapping(value = "/employees/{id}", method = RequestMethod.DELETE)
    public String deleteEmployee(@PathVariable int id) {

        employeeService.deleteEmployee(id);

        return "success";

    }

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public ModelAndView employeeView() {

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("employee");
        return modelAndView;

    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    public ModelAndView employeeUpdateView(@PathVariable int id) {

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("employee", employeeService.getEmployeeById(id));
        modelAndView.setViewName("employee");
        return modelAndView;

    }

    @RequestMapping(value = "/employees", method = RequestMethod.POST)
    public ModelAndView addEmployee(@RequestParam String name,
                                    @RequestParam String role) {

        Employee employee = new Employee(name,role);

        employeeService.addEmployee(employee);

        return new ModelAndView("redirect:/employees");

    }

    @RequestMapping(value = "/employees/{id}", method = RequestMethod.POST)
    public ModelAndView updateEmployee(@PathVariable int id,
                                       @RequestParam String name,
                                       @RequestParam String role) {

        Employee employee = new Employee(id,name,role);

        employeeService.updateEmployee(employee);

        return new ModelAndView("redirect:/employees");

    }
}
