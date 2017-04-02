package com.hihoall.dao;

import com.hihoall.entity.Reviews;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Brightsunrise on 30.12.2016.
 */

@Repository
public class ReviewsDAO implements DAO<Reviews>   {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Reviews> getList() {
        return null;
    }

    @Override
    public List<Reviews> getList(int param) {
        return null;
    }

    @Override
    public List<Reviews> getList(String paramName1, String paramValue1, String paramName2, String paramValue2) {
        return null;
    }

    @Override
    public List<Reviews> getListOrderBy(String param, String how) {
        return null;
    }

    @Override
    public List<Reviews> getList(String paramName1, int paramValue1, String paramName2, String paramValue2) {
        return null;
    }

    @Override
    public Reviews get(int id) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Reviews get(Long id) {
        return null;
    }

    @Override
    public Reviews get(String uniqParam, String valueTheParam) {
        return null;
    }

    @Override
    public Reviews get(String firstParam, int firstValue, String secondParam, String secondValue) {
        return null;
    }

    @Override
    public void add(Reviews obj) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(obj);
    }

    @Override
    public List<Reviews> search(String searchString) {
        return null;
    }

    @Override
    public void update(String column, Float value, int id) {

    }

    @Override
    public void update(String column, int value, int id) {

    }

    @Override
    public void delete(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query q = currentSession.createQuery("DELETE Reviews WHERE id = '" + id + "'");
        q.executeUpdate();
    }
}
