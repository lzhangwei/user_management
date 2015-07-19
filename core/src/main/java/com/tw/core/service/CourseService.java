package com.tw.core.service;

import com.tw.core.dao.CourseDao;
import com.tw.core.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseDao courseDao;

    public boolean addCourse(Date time, int coachId, int customerId, int courseId) {
        return courseDao.addCourse(time, coachId, customerId, courseId);
    }

    public List<Course> getCourseByCoachId(int id) {
        return courseDao.getCourseByCoachId(id);
    }
}
