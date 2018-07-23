package com.springweb;


import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.springweb.dto.User;
import com.springweb.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/conf/applicationContext.xml" })
public class TestUserService {
    @Autowired
    private UserService userService;
    
    @Test
    public void findUserByUsername(){
        User user = userService.findUserByUsername("tom");
        assertEquals(user.getName(), "tom");
    }
    
    
}