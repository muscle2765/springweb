package com.springweb.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springweb.dao.IUserDao;
import com.springweb.dto.User;


@Service
public class UserService {
    @Autowired
    private IUserDao userdao;
    
    public User findUserByUsername(String username) {
        return userdao.findUserByName(username);
    }
    
    public int validate(User user) {
        return userdao.validate(user);
    }

    public void addUser(User user) {
        userdao.addUser(user);
    }
}