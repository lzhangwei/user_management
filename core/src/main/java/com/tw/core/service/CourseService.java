package com.tw.core.service;

import com.tw.core.dao.ArrangementDao;
import com.tw.core.dao.CourseDao;
import com.tw.core.dao.CustomerDao;
import com.tw.core.dao.UserDao;
import com.tw.core.entity.Arrangement;
import com.tw.core.entity.Coach;
import com.tw.core.entity.Course;
import com.tw.core.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class CourseService {

    @Autowired
    private CourseDao courseDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private ArrangementDao arrangementDao;

    @Autowired
    private CustomerDao customerDao;

    public boolean addCourse(Date time, int coachId, int customerId, int courseId) {

        if (isAppointment(time, coachId)) {

            return false;

        } else {

            Customer customer = customerDao.getCustomerById(customerId);
            Course course = courseDao.getCourseById(courseId);

            customer.addCourse(course);

            Arrangement arrangement = new Arrangement(time, course, customer);

            arrangementDao.addArrangement(arrangement);

            customerDao.updateCustomer(customer);

            return true;
        }
    }

    public boolean addPrivateCourse(Date time, int coachId, int customerId) {

        if (isAppointment(time, coachId)) {

            return false;

        } else {

            Customer customer = customerDao.getCustomerById(customerId);
            Course course = courseDao.getPrivateCourseByCoachId(coachId);

            Arrangement arrangement = new Arrangement(time, course, customer);

            arrangementDao.addArrangement(arrangement);

            return true;
        }
    }

    private boolean isAppointment(Date time, int coachId) {

        Coach coach = userDao.getCoachById(coachId);

        Set<Course> courses = coach.getCourses();

        for (Course course : courses) {
            List<Arrangement> arrangements = arrangementDao.getArrangementByDateAndCourse(time, course.getId());
            if (arrangements.size() > 0) {
                return true;
            }
        }

        return false;

    }

    public List<Course> getCourseByCoachId(int id) {
        return courseDao.getCourseByCoachId(id);
    }

    public boolean addPublicCourse(Date time, int coachId, int courseId) {
        if (isAppointment(time, coachId)) {

            return false;

        } else {

//            Customer customer = customerDao.getCustomerById(customerId);
            Course course = courseDao.getCourseById(courseId);

            Arrangement arrangement = new Arrangement(time, course, null);

            arrangementDao.addArrangement(arrangement);

            return true;
        }
    }

    public List<Course> getAllPublicCourse() {

        return courseDao.getAllPublicCourse();
    }
}
