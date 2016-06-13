package com.necl.serviceImpl;

import com.necl.dao.UserProfileDao;
import com.necl.model.UserProfile;
import com.necl.service.UserProfileService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userProfileService")
@Transactional
public class UserProfileServiceImpl implements UserProfileService{
     
    @Autowired
    UserProfileDao userProfiledao;
     
    @Override
    public List<UserProfile> findAll() {
        return userProfiledao.findAll();
    }
 
    @Override
    public UserProfile findByType(String type){
        return userProfiledao.findByType(type);
    }
 
    @Override
    public UserProfile findById(int id) {
        return userProfiledao.findById(id);
    }
}
