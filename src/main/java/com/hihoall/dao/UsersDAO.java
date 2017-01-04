package com.hihoall.dao;

import com.hihoall.entity.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Brightsunrise on 14.12.2016.
 */

@Repository
public class UsersDAO implements DAO<Users> {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Users> getList() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Users> theQuery = currentSession.createQuery("from Users", Users.class);
        List<Users> users = theQuery.getResultList();
        return users;
    }

    @Override
    public Users get(int id) {
        return null;
    }

    @Override
    public Users get(String uniqParam, String valueTheParam) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Users> theQuery = currentSession.createQuery("FROM Users s WHERE s." + uniqParam + "='" + valueTheParam + "'", Users.class);
        Users theUser = theQuery.getSingleResult();
        return theUser;
    }

    @Override
    public Users get(String firstParam, int firstValue, String secondParam, String secondValue) {
        return null;
    }

    @Override
    public List<Users> getList(int param) {
        return null;
    }

    @Override
    public List<Users> getList(String paramName1, String paramValue1, String paramName2, String paramValue2) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Users> theQuery = currentSession.createQuery("from Users s where"
                + " s." + paramName1 + "='" + paramValue1 + "' " + "AND s." + paramName2 + "='" + paramValue2 + "'", Users.class);
        List<Users> users = theQuery.getResultList();
        return users;
    }

    @Override
    public List<Users> getListOrderBy(String param, String how) {
        return null;
    }

    @Override
    public List<Users> getList(String paramName1, int paramValue1, String paramName2, String paramValue2) {
        return null;
    }

    @Override
    public void add(Users obj) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(obj);
    }

    @Override
    public List<Users> search(String searchString) {
        return null;
    }

    @Override
    public void update(String column, Float value, int id) {

    }

    @Override
    public void update(String column, int value, int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.createQuery("UPDATE Users SET " + column +" = " + value + " WHERE id = '"  + id + "'")
                .executeUpdate();
    }
}
