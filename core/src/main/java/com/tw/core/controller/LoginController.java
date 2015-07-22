package com.tw.core.controller;

import com.tw.core.service.ArrangementService;
import com.tw.core.service.UserService;
import com.tw.core.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private ArrangementService arrangementService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView index() {

        return new ModelAndView("index");

    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(@RequestParam String name,
                              @RequestParam String password,
                              HttpServletResponse response,
                              HttpServletRequest request) {

//        password = Utils.encryptPassword(password);

        int userId = userService.login(name, password);

        if (userId > 0) {

            Cookie cookie = new Cookie("isLogin", "login");
            response.addCookie(cookie);

            String url = Utils.getCookieUrl(request);

            if (url != null) {
                return new ModelAndView("redirect:/" + url);
            } else {
                return new ModelAndView("redirect:/main");
            }

        } else {
            return new ModelAndView("redirect:/login");
        }

    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout(HttpServletResponse response) {

        Cookie cookieLogin = new Cookie("isLogin", "logout");
        cookieLogin.setMaxAge(0);

        Cookie cookieUrl = new Cookie("previous_page", "");
        cookieUrl.setMaxAge(0);

        response.addCookie(cookieLogin);
        response.addCookie(cookieUrl);

        return new ModelAndView("index");

    }


}
