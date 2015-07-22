package com.tw.core.dao;

import com.tw.core.entity.Arrangement;
import com.tw.core.util.HibernateUtil;
import com.tw.core.util.Utils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class ArrangementDao {

    public List<Arrangement> getAllArrangement() {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createSQLQuery("select * from course_customer_date").addEntity(Arrangement.class);
        List<Arrangement> arrangements = query.list();
        session.close();
        return arrangements;

    }

    public List<Arrangement> getArrangementByDateAndCourse(Date date, int courseId) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createSQLQuery("select * from course_customer_date where DATE = '" + Utils.formatDate(date) + "' and course_id = " + courseId).addEntity(Arrangement.class);
        List<Arrangement> arrangements = query.list();
        session.close();
        return arrangements;

    }

    public void addArrangement(Arrangement arrangement) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            session.save(arrangement);

        } catch (Exception e) {
            e.printStackTrace();
        }
        session.getTransaction().commit();
        session.close();
    }

}
