package com.tw.core.controller;

import com.tw.core.service.CourseService;
import com.tw.core.service.CustomerService;
import com.tw.core.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    public ModelAndView customerList() {

        ModelAndView modelAndView = new ModelAndView();

//        modelAndView.addObject("coaches", employeeService.getAllCoach());
        modelAndView.addObject("courses", courseService.getAllPublicCourse());
        modelAndView.addObject("customers", customerService.getAllCustomer());
        modelAndView.setViewName("add_course");
        return modelAndView;

    }


    @RequestMapping(value = "/courses", method = RequestMethod.POST)
    public ModelAndView addCourse(@RequestParam Date time,
                                  @RequestParam int coachId,
                                  @RequestParam int customerId) {

        boolean isSuccess = courseService.addPrivateCourse(time, coachId, customerId);

        if(isSuccess) {
            return new ModelAndView("redirect:/main");
        } else {
            return new ModelAndView("redirect:/courses");
        }

    }

    @RequestMapping(value = "/courses/public", method = RequestMethod.POST)
    public ModelAndView addPublicCourse(@RequestParam Date time,
                                  @RequestParam int coachId,
                                  @RequestParam int courseId) {

        boolean isSuccess = courseService.addPublicCourse(time, coachId, courseId);

        if(isSuccess) {
            return new ModelAndView("redirect:/main");
        } else {
            return new ModelAndView("redirect:/courses");
        }

    }

}
