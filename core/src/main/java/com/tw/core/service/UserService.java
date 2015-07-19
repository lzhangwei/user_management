package com.tw.core.service;

import com.tw.core.dao.UserDao;
import com.tw.core.entity.Coach;
import com.tw.core.entity.Course;
import com.tw.core.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public Course getCourseById(int id) {
        return userDao.getCourseById(id);
    }

    public List<Coach> getCoaches() {
        return userDao.getCoaches();
    }

    public List<User> getUsers() {
        return userDao.getUsers();
    }

    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }

    public void addUser(User user) {
        userDao.addUser(user);
    }

    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    public int login(String name, String password) {
        return userDao.login(name, password);
    }

    public Coach getCoachById(int userId) {
        return userDao.getCoachById(userId);
    }
}