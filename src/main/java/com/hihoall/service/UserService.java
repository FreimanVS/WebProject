package com.hihoall.service;

import com.hihoall.dao.DAO;
import com.hihoall.entity.Role;
import com.hihoall.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Brightsunrise
 * @version 1.0
 */

@Service
public class UserService extends AbstractService<User> {

    @Autowired
    DAO<User> userDao;

    @Autowired
    DAO<Role> roleDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    @Transactional
    public void add(User user) {
        Set<Role> roles = new HashSet<>();
        roles.add(roleDao.get("name", "ROLE_USER"));
        user.setRoles(roles);

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userDao.add(user);
    }
}
