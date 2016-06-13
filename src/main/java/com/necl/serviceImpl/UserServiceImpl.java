/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.necl.serviceImpl;

import com.necl.dao.UserDao;
import com.necl.model.User;
import com.necl.service.UserService;
import com.necl.controller.HomeController;
import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author C13.207
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private SessionFactory sessionFactory;

//    @Autowired
//    private PasswordEncoder passwordEncoder;
    @Override
    public User findById(long id) throws Exception {
        return userDao.findById(id);
    }

    @Override
    public List<User> findAll() throws Exception {
        return userDao.findAll();
    }

    @Override
    public boolean save(User user) throws Exception {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userDao.save(user);
    }

    @Override
    public boolean update(User user) throws Exception {
        return userDao.update(user);
    }

    @Override
    public boolean delete(User user) throws Exception {
        return userDao.delete(user);
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public List<User> findBySubSectionCode(String subSectionCode) {
      return userDao.findBySubSectionCode(subSectionCode);
    }

    @Override
    public List<User> getMD() throws Exception {
        return userDao.getMD();
    }

    @Override
    public String resetPassword(String oldPassword, String newPassword, String confirm_newpassword) throws Exception {
        return userDao.resetPassword(oldPassword, newPassword, confirm_newpassword);
    }

}
