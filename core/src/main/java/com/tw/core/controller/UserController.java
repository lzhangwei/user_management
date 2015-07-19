package com.tw.core.controller;

import com.tw.core.entity.User;
import com.tw.core.service.UserService;
import com.tw.core.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ModelAndView userView() {

        return new ModelAndView("user");

    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ModelAndView userView(@PathVariable int id) {

        User user = userService.getUserById(id);

        return new ModelAndView("user", "user", user);

    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView getUsers() {

        return new ModelAndView("users", "users", userService.getUsers());

    }

    @RequestMapping(value = "/users", method = RequestMethod.DELETE)
    public String deleteUser(@RequestParam int id) {

        userService.deleteUser(id);
        return "success";
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.POST)
    public ModelAndView addUser(@PathVariable int id,
                                @RequestParam String name,
                                @RequestParam String password) {

        password = Utils.encryptPassword(password);

        User user = new User(id, name, password);

        if (user.getId() != 0) {
            userService.updateUser(user);
        } else {
            userService.addUser(user);
        }

        return new ModelAndView("redirect:/users");

    }

    @RequestMapping(value = "/users", method = RequestMethod.PUT)
    public void updateUser(@RequestBody User user) {

        userService.updateUser(user);

    }
}
