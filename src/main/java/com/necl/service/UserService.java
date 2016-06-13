/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.necl.service;

import com.necl.model.User;
import java.util.List;

/**
 *
 * @author C13.207
 */
public interface UserService {

    public User findById(long id) throws Exception;
    public List<User> findAll() throws Exception;
    public boolean save(User user) throws Exception;
    public boolean update(User user) throws Exception;
    public boolean delete(User user) throws Exception;
    public User findByUsername(String username);
    public List<User> findBySubSectionCode(String subSectionCode);
    public List<User> getMD() throws Exception;
    public String resetPassword(String oldPassword, String newPassword, String confirm_newpassword) throws Exception;

}
