package com.hihoall.dao;

import com.hihoall.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Brightsunrise
 * @version 1.0
 */

@Repository
public class UserDAO implements DAO<User> {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<User> getList() {
        return sessionFactory.getCurrentSession().createQuery("FROM User", User.class)
                .getResultList();
    }

    @Override
    public List<User> getList(int param) { return null;}

    @Override
    public List<User> getList(String paramName1, String paramValue1, String paramName2, String paramValue2) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<User> theQuery = currentSession.createQuery("FROM User s WHERE"
                + " s." + paramName1 + "='" + paramValue1 + "' " + "AND s." + paramName2 + "='" + paramValue2 + "'", User.class);
        List<User> users = theQuery.getResultList();
        return users;
    }

    @Override
    public List<User> getListOrderBy(String param, String how) {
        return null;
    }

    @Override
    public List<User> getList(String paramName1, int paramValue1, String paramName2, String paramValue2) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<User> theQuery = currentSession.createQuery("FROM User s WHERE"
                + " s." + paramName1 + "='" + paramValue1 + "' " + "AND s." + paramName2 + "='" + paramValue2 + "'", User.class);
        List<User> users = theQuery.getResultList();
        return users;
    }

    @Override
    public User get(int id) {
        return null;
    }

    @Override
    public User get(Long id) {
        return null;
    }

    @Override
    public User get(String uniqParam, String valueTheParam) {
        List<User> users = sessionFactory.getCurrentSession()
                .createQuery("from User s where s." + uniqParam + " = :valueTheParam")
                .setParameter("valueTheParam", valueTheParam, org.hibernate.type.StringType.INSTANCE)
                .list();

        if (users == null || users.isEmpty()) {
            return null;
        }

        return users.get(0);
    }

    @Override
    public User get(String firstParam, int firstValue, String secondParam, String secondValue) {
        return null;
    }

    @Override
    public void add(User obj) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(obj);
    }

    @Override
    public List<User> search(String searchString) {
        return null;
    }

    @Override
    public void update(String column, Float value, int id) {

    }

    @Override
    public void update(String column, int value, int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.createQuery("UPDATE Users SET " + column + " = " + value + " WHERE id = '"  + id + "'")
                .executeUpdate();
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void delete(Long id) {

    }
}
