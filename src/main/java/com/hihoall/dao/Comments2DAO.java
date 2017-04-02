package com.hihoall.dao;

import com.hihoall.entity.Comments2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.type.IntegerType;
import org.hibernate.type.LongType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Brightsunrise on 14.12.2016.
 */

@Repository
public class Comments2DAO implements DAO<Comments2> {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Comments2> getList() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Comments2> theQuery = currentSession.createQuery("FROM Comments2", Comments2.class);
        List<Comments2> comments2 = theQuery.getResultList();
        return comments2;
    }

    @Override
    public Comments2 get(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();

        Comments2 comments2 = currentSession.get(Comments2.class, id);

        return comments2;
    }

    @Override
    public Comments2 get(int id) {
        Session currentSession = sessionFactory.getCurrentSession();

        Comments2 comments2 = currentSession.get(Comments2.class, id);

        return comments2;
    }

    @Override
    public Comments2 get(String uniqParam, String valueTheParam) {
        return null;
    }

    @Override
    public Comments2 get(String firstParam, int firstValue, String secondParam, String secondValue) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Comments2> theQuery = currentSession.createQuery("FROM Comments2 s WHERE s." + firstParam + "='" + firstValue + "' " +
                "AND s." + secondParam + "='" + secondValue + "'" , Comments2.class);
        Comments2 theComment = theQuery.getSingleResult();
        return theComment;
    }

    @Override
    public List<Comments2> getList(int param) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Comments2> theQuery = currentSession.createQuery("FROM Comments2 s WHERE s.idmovie='" + param + "'", Comments2.class);
        List<Comments2> comments2 = theQuery.getResultList();
        return comments2;
    }

    @Override
    public List<Comments2> getList(String paramName1, String paramValue1, String paramName2, String paramValue2) {
        return null;
    }

    @Override
    public List<Comments2> getListOrderBy(String param, String how) {
        return null;
    }

    @Override
    public List<Comments2> getList(String paramName1, int paramValue1, String paramName2, String paramValue2) {
        return null;
    }

    @Override
    public void add(Comments2 obj) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(obj);
    }

    @Override
    public List<Comments2> search(String searchString) {

        Session currentSession = sessionFactory.getCurrentSession();

        Query theQuery = null;

        if (searchString != null && searchString.trim().length() > 0) {

            theQuery =currentSession.createQuery("FROM Comments2 WHERE lower(namemovie) LIKE :theString" +
                    " OR lower(content) LIKE :theString" +
                    " OR lower(nick) LIKE :theString", Comments2.class);
            theQuery.setParameter("theString", "%" + searchString.toLowerCase() + "%");

        }
        else {
            theQuery =currentSession.createQuery("FROM Comments2", Comments2.class);
        }

        List<Comments2> listComments2 = theQuery.getResultList();

        return listComments2;
    }

    @Override
    public void update(String column, Float value, int id) {

    }

    @Override
    public void update(String column, int value, int id) {

    }

    @Override
    public void delete(int id) {
        Session currentSession = sessionFactory.getCurrentSession();

        Query theQuery =
                currentSession.createQuery("DELETE FROM Comments2 WHERE id = :id");
        theQuery.setParameter("id", id, IntegerType.INSTANCE);

        theQuery.executeUpdate();
    }

    @Override
    public void delete(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("DELETE FROM Comments2 WHERE id = :id");
        query.setParameter("id", id, LongType.INSTANCE);
        query.executeUpdate();
    }
}
