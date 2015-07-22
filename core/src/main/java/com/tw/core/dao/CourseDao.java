package com.tw.core.dao;

import com.tw.core.entity.Coach;
import com.tw.core.entity.Course;
import com.tw.core.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Repository
public class CourseDao {

    public Course getCourseById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query queryCourse = session.createSQLQuery("select * from course WHERE id = " + id).addEntity(Course.class);
        List<Course> courses = queryCourse.list();
        session.close();
        return courses.get(0);
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

    public Course getPrivateCourseByCoachId(int coachId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query queryCourse = session.createSQLQuery("select * from course WHERE coach_id = " + coachId + " and name='私教课'").addEntity(Course.class);
        List<Course> courses = queryCourse.list();
        session.close();
        return courses.get(0);
    }


    public void updateCourse(Course course) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(course);
        session.getTransaction().commit();
        session.close();
    }

    public List<Course> getAllCourse() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createSQLQuery("select * from course").addEntity(Course.class);
        List<Course> courses = query.list();
        session.close();
        return courses;
    }

    public void addCourse(Course course) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(course);
        session.getTransaction().commit();
        session.close();
    }

    public void deleteCourse(Course course) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(course);
        session.getTransaction().commit();
        session.close();
    }

    public List<Course> getAllPublicCourse() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createSQLQuery("select * from course where name!='私教课'").addEntity(Course.class);
        List<Course> courses = query.list();
        session.close();
        return courses;
    }
}
