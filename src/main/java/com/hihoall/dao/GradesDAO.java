package com.hihoall.dao;

import com.hihoall.entity.Grades;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Brightsunrise on 25.12.2016.
 */

@Repository
public class GradesDAO implements DAO<Grades>  {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Grades> getList() {
        return null;
    }

    @Override
    public Grades get(int id) {
        return null;
    }

    @Override
    public Grades get(String uniqParam, String valueTheParam) {
        return null;
    }

    @Override
    public Grades get(Long id) {
        return null;
    }

    @Override
    public Grades get(String firstParam, int firstValue, String secondParam, String secondValue) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Grades> theQuery = currentSession
                .createQuery("FROM Grades s WHERE s." + firstParam + "='" + firstValue + "' " +
                "AND s." + secondParam + "='" + secondValue + "'" , Grades.class)
                .setMaxResults(1);

        List<Grades> list = theQuery.getResultList();
        if (list == null || list.isEmpty()) {
            return null;
        }

        return list.get(0);
    }

    @Override
    public List<Grades> getList(int param) {
        return null;
    }

    @Override
    public List<Grades> getList(String paramName1, String paramValue1, String paramName2, String paramValue2) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Grades> theQuery = currentSession.createQuery("FROM Grades s WHERE"
                + " s." + paramName1 + "='" + paramValue1 + "' " + "AND s." + paramName2 + "='" + paramValue2 + "'", Grades.class);
        List<Grades> grades = theQuery.getResultList();

        return grades;
    }

    @Override
    public List<Grades> getList(String paramName1, int paramValue1, String paramName2, String paramValue2) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Grades> theQuery = currentSession.createQuery("FROM Grades s WHERE"
                + " s." + paramName1 + "='" + paramValue1 + "' " + "AND s." + paramName2 + "='" + paramValue2 + "'", Grades.class);
        List<Grades> grades = theQuery.getResultList();

        return grades;
    }

    @Override
    public List<Grades> getListOrderBy(String param, String how) {
        return null;
    }

    @Override
    public void add(Grades obj) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(obj);
    }

    @Override
    public List<Grades> search(String searchString) {
        return null;
    }

    @Override
    public void update(String column, Float value, int id) {

    }

    @Override
    public void update(String column, int value, int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.createQuery("UPDATE Grades SET " + column + " = " + value + " WHERE id = '"  + id + "'")
                .executeUpdate();
    }

    @Override
    public void delete(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query q = currentSession.createQuery("DELETE FROM Grades WHERE id = '" + id + "'");
        q.executeUpdate();
    }

    @Override
    public void delete(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query q = currentSession.createQuery("DELETE FROM Grades WHERE id = '" + id + "'");
        q.executeUpdate();
    }
}
