package com.springweb.dao;

import com.springweb.dto.User;

public interface IUserDao {
	
	public User findUserByName(String name);
	
	public void updateUser(User user);
	
	public void addUser(User user);
	
	public int validate(User user);
}
