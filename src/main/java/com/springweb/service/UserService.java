package com.springweb.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springweb.dao.UserDao;
import com.springweb.dto.User;


@Service
public class UserService {
    @Autowired
    private UserDao userdao;
    
    public User findUserByUsername(String username) {
        return userdao.findUserByName(username);
    }
    
    public int validate(User user) {
        return userdao.validate(user);
    }

}