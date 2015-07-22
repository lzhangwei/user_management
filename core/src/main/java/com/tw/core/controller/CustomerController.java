package com.tw.core.controller;

import com.tw.core.entity.Coach;
import com.tw.core.entity.Customer;
import com.tw.core.service.CustomerService;
import com.tw.core.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public ModelAndView customerList() {

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("customers", customerService.getAllCustomer());
        modelAndView.setViewName("customers");
        return modelAndView;

    }

    @RequestMapping(value = "/customers/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable int id) {

        customerService.deleteCustomer(id);

        return "success";

    }

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public ModelAndView customerView() {

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("coaches", employeeService.getAllCoach());
        modelAndView.setViewName("customer");
        return modelAndView;

    }

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
    public ModelAndView customerUpdateView(@PathVariable int id) {

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("coaches", employeeService.getAllCoach());
        modelAndView.addObject("customer", customerService.getCustomerById(id));
        modelAndView.setViewName("customer");
        return modelAndView;

    }

    @RequestMapping(value = "/customers", method = RequestMethod.POST)
    public ModelAndView addCustomer(@RequestParam String name,
                                    @RequestParam int coachId) {

        Customer customer = new Customer(name, new Coach(coachId));

        customerService.addCustomer(customer);

        return new ModelAndView("redirect:/customers");

    }

    @RequestMapping(value = "/customers/{id}", method = RequestMethod.POST)
    public ModelAndView updateCustomer(@PathVariable int id,
                                       @RequestParam String name,
                                       @RequestParam int coachId) {

        Customer customer = new Customer(id, name, new Coach(coachId));

        customerService.updateCustomer(customer);

        return new ModelAndView("redirect:/customers");

    }

}
