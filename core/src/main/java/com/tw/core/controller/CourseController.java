package com.tw.core.controller;

import com.tw.core.service.CourseService;
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

    @RequestMapping(value = "/courses", method = RequestMethod.POST)
    public ModelAndView addCourse(@RequestParam Date time,
                                  @RequestParam int coachId,
                                  @RequestParam int customerId,
                                  @RequestParam int courseId) {

        boolean isSuccess = courseService.addCourse(time, coachId, customerId, courseId);

        if(isSuccess) {
            return new ModelAndView("course");
        } else {
            return new ModelAndView("add_course");
        }

    }

}
