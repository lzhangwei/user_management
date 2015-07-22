package com.tw.core.controller;

import com.tw.core.service.ArrangementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MainController {

    @Autowired
    private ArrangementService arrangementService;

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public ModelAndView index() {

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("arrangements", arrangementService.getAllArrangement());
        modelAndView.setViewName("main");
        return modelAndView;

    }

}
