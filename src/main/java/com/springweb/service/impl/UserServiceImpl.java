package com.springweb.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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
    
    
    @Cacheable("getUserByName") //标注该方法查询的结果进入缓存，再次访问时直接读取缓存中的数据
    // 设置事务超时时间、隔离级别、传播行为
	@Transactional(timeout=1000, isolation=Isolation.DEFAULT, propagation=Propagation.REQUIRED)		
    @Override
    public User findUserByUsername(String username) {
    	System.out.println("cache user");
        return userdao.findUserByName(username);
    }
    
    @Cacheable("getNameById") //标注该方法查询的结果进入缓存，再次访问时直接读取缓存中的数据
    // 设置事务超时时间、隔离级别、传播行为
	@Transactional(timeout=1000, isolation=Isolation.DEFAULT, propagation=Propagation.REQUIRED)		
    @Override
    public String getNameById(int id) {
    	System.out.println("cache id");
        return userdao.getNameById(id);
    }
    
    @Override
    public int validate(User user) {
        return userdao.validate(user);
    }
    
    @CacheEvict(value= {"getUserByName"},allEntries=true)//清空缓存，allEntries变量表示所有对象的缓存都清除
    @Override
    public void addUser(User user) {
        userdao.addUser(user);
    }
}