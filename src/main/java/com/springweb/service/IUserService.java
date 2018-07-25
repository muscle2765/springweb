package com.springweb.service;

import com.springweb.dto.User;
import com.springweb.util.datasource.DataSource;

public interface IUserService {

	@DataSource("slave")
	public User findUserByUsername(String username);
    
	@DataSource("slave")
    public int validate(User user);

    @DataSource("master")
    public void addUser(User user);

    @DataSource("slave")
	public String getNameById(int id);
}
