package com.springweb.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.springweb.dao.IUserDao;
import com.springweb.dto.User;
import com.springweb.service.IUserService;


@Service
public class UserServiceImpl implements IUserService{
    @Autowired
    private IUserDao userdao;
    
    
    // 设置事务超时时间、隔离级别、传播行为
	@Transactional(timeout=1000, isolation=Isolation.DEFAULT, propagation=Propagation.REQUIRED)		
    @Override
    public User findUserByUsername(String username) {
        return userdao.findUserByName(username);
    }
    
    @Override
    public int validate(User user) {
        return userdao.validate(user);
    }
    
    @Override
    public void addUser(User user) {
        userdao.addUser(user);
    }
}