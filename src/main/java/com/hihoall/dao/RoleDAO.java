package com.hihoall.dao;

import com.hihoall.entity.Role;
import org.hibernate.SessionFactory;
import org.hibernate.type.StringType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Brightsunrise
 * @version 1.0
 */

@Repository
public class RoleDAO implements DAO<Role> {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Role> getList() {
        return null;
    }

    @Override
    public List<Role> getList(int param) {
        return null;
    }

    @Override
    public List<Role> getList(String paramName1, String paramValue1, String paramName2, String paramValue2) {
        return null;
    }

    @Override
    public List<Role> getListOrderBy(String param, String how) {
        return null;
    }

    @Override
    public List<Role> getList(String paramName1, int paramValue1, String paramName2, String paramValue2) {
        return null;
    }

    @Override
    public Role get(int id) {
        return null;
    }

    @Override
    public Role get(Long id) {
        return null;
    }

    @Override
    public Role get(String uniqParam, String valueTheParam) {
        List<Role> roles = sessionFactory.getCurrentSession()
                .createQuery("FROM Role s WHERE s." + uniqParam + " = :valueTheParam")
                .setParameter("valueTheParam", valueTheParam, StringType.INSTANCE)
                .list();

        if (roles == null || roles.isEmpty()) {
            return null;
        }

        return roles.get(0);
    }

    @Override
    public Role get(String firstParam, int firstValue, String secondParam, String secondValue) {
        return null;
    }

    @Override
    public void add(Role obj) {

    }

    @Override
    public List<Role> search(String searchString) {
        return null;
    }

    @Override
    public void update(String column, Float value, int id) {

    }

    @Override
    public void update(String column, int value, int id) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void delete(Long id) {

    }
}
