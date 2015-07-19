package com.tw.core.dao;

import com.tw.core.entity.Coach;
import com.tw.core.entity.Course;
import com.tw.core.entity.CourseArrangement;
import com.tw.core.entity.Customer;
import com.tw.core.util.HibernateUtil;
import com.tw.core.util.Utils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Repository
public class CourseDao {

    public boolean addCourse(Date time, int coachId, int customerId, int courseId) {

        if(isAppointment(time, coachId)) {
            return false;
        } else {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createSQLQuery("select * from customer WHERE id = " + customerId).addEntity(Customer.class);
            List<Customer> customers = query.list();

            Query queryCourse = session.createSQLQuery("select * from course WHERE id = " + courseId).addEntity(Course.class);
            List<Course> courses = queryCourse.list();

            Customer customer = customers.get(0);
            customer.addCourse(courses.get(0));

            CourseArrangement courseArrangement = new CourseArrangement(time, courses.get(0));

            session.beginTransaction();

            session.update(customer);
            session.save(courseArrangement);

            session.getTransaction().commit();


            session.close();

            return true;
        }
    }

    public List<Course> getCourseByCoachId(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Query query = session.createSQLQuery("select * from employee where role = 'coach' and id = " + id).addEntity(Coach.class);
        List<Coach> coaches = query.list();

        Set<Course> courses = coaches.get(0).getCourses();

        List<Course> courseList = new ArrayList<Course>(courses);

        session.close();

        return courseList;
    }

    private boolean isAppointment(Date time, int coachId) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Query query = session.createSQLQuery("select * from employee where role = 'coach' and id = " + coachId).addEntity(Coach.class);
        List<Coach> coaches = query.list();

        Set<Course> courses = coaches.get(0).getCourses();

        for (Course course : courses) {
            Query queryTime = session.createSQLQuery("select * from arrangement where DATE = '" + Utils.formateDate(time) +"' and course_id = " + course.getId()).addEntity(CourseArrangement.class);
            List<CourseArrangement> courseArrangements = queryTime.list();
            if(courseArrangements.size()>0) {
                return true;
            }
        }

        session.close();

        return false;
    }

}
