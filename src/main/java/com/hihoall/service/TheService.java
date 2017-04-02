package com.hihoall.service;

import java.util.List;

/**
 * Created by Brightsunrise on 14.12.2016.
 */
public interface TheService<T> {
    List<T> getList();

    List<T> getList(int param);

    List<T> getList(String paramName1, String paramValue1, String paramName2, String paramValue2);

    List<T> getList(String paramName1, int paramValue1, String paramName2, String paramValue2);

    List<T> getListOrderBy(String param, String how);

    T get(int id);

    T get(Long id);

    T get(String uniqParam, String valueTheParam);

    T get(String firstParam, int firstValue, String secondParam, String secondValue);

    void add(T obj);

    List<T> search(String searchString);

    void update(String column, Float value, int id);

    void update(String column, int value, int id);

    void delete(int id);

    void delete(Long id);
}
