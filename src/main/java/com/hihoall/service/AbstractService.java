package com.hihoall.service;

import com.hihoall.dao.DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Brightsunrise on 30.12.2016.
 */

public class AbstractService<T> implements TheService<T>   {
    @Autowired
    private DAO<T> dao;

    @Override
    @Transactional
    public List<T> getList() {
        return dao.getList();
    }

    @Override
    @Transactional
    public List<T> getList(int param) {
        return dao.getList(param);
    }

    @Override
    @Transactional
    public List<T> getList(String paramName1, String paramValue1, String paramName2, String paramValue2) {
        return dao.getList(paramName1, paramValue1, paramName2, paramValue2);
    }

    @Override
    @Transactional
    public List<T> getList(String paramName1, int paramValue1, String paramName2, String paramValue2) {
        return dao.getList(paramName1, paramValue1, paramName2, paramValue2);
    }

    @Override
    @Transactional
    public List<T> getListOrderBy(String param, String how) {
        return dao.getListOrderBy(param, how);
    }

    @Override
    @Transactional
    public T get(int id) {
        return dao.get(id);
    }

    @Override
    @Transactional
    public T get(Long id) {
        return dao.get(id);
    }

    @Override
    @Transactional
    public T get(String uniqParam, String valueTheParam) {
        return dao.get(uniqParam, valueTheParam);
    }

    @Override
    @Transactional
    public T get(String firstParam, int firstValue, String secondParam, String secondValue) {
        return dao.get(firstParam, firstValue, secondParam, secondValue);
    }

    @Override
    @Transactional
    public void delete(int id) {
        dao.delete(id);
    }

    @Override
    @Transactional
    public void add(T obj) {
        dao.add(obj);
    }

    @Override
    @Transactional
    public List<T> search(String searchString) {
        return dao.search(searchString);
    }

    @Override
    @Transactional
    public void update(String column, Float value, int id) {
        dao.update(column, value, id);
    }

    @Override
    @Transactional
    public void update(String column, int value, int id) {
        dao.update(column, value, id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        dao.delete(id);
    }
}
