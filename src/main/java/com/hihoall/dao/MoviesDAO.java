package com.hihoall.dao;

import com.hihoall.entity.Movies;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Brightsunrise on 17.12.2016.
 */

@Repository
public class MoviesDAO implements DAO<Movies>  {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Movies> getList() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Movies> theQuery = currentSession.createQuery("from Movies", Movies.class);
        List<Movies> movies = theQuery.getResultList();
        return movies;
    }

    @Override
    public Movies get(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Movies> theQuery = currentSession.createQuery("from Movies s where s.id='" + id + "'", Movies.class);
        Movies movie = theQuery.getSingleResult();
        return movie;
    }

    @Override
    public Movies get(String uniqParam, String valueTheParam) {
        return null;
    }

    @Override
    public Movies get(String firstParam, int firstValue, String secondParam, String secondValue) {
        return null;
    }

    @Override
    public List<Movies> getList(int param) {
        return null;
    }

    @Override
    public List<Movies> getList(String paramName1, String paramValue1, String paramName2, String paramValue2) {
        return null;
    }

    @Override
    public List<Movies> getListOrderBy(String param, String how) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Movies> theQuery = currentSession.createQuery("FROM Movies s ORDER BY s." + param + " " + how, Movies.class);
        List<Movies> movies = theQuery.getResultList();
        return movies;
    }

    @Override
    public List<Movies> getList(String paramName1, int paramValue1, String paramName2, String paramValue2) {
        return null;
    }

    @Override
    public void add(Movies obj) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(obj);
    }

    @Override
    public List<Movies> search(String searchString) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Movies> theQuery = currentSession.createQuery("FROM Movies s WHERE s.namemovie LIKE '%" + searchString +
                "%' OR s.description LIKE '%" + searchString +
                "%' OR s.timefilmed LIKE '%" + searchString +
                "%' OR s.director LIKE '%" + searchString + "%'", Movies.class);
        List<Movies> movies = theQuery.getResultList();
        return movies;
    }

    @Override
    public void update(String column, Float value, int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.createQuery("UPDATE Movies SET " + column +" = " + value + " WHERE idmovie = '"  + id + "'")
                .executeUpdate();
    }

    @Override
    public void update(String column, int value, int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.createQuery("UPDATE Movies SET " + column +" = " + value + " WHERE idmovie = '"  + id + "'")
                .executeUpdate();
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Movies get(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query q = currentSession.createQuery("delete Movies where id = '" + id + "'");
        q.executeUpdate();
    }
}
