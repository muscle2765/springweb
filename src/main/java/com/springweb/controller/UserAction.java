package com.springweb.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.springweb.dto.LoginLog;
import com.springweb.dto.User;
import com.springweb.service.LoginLogService;
import com.springweb.service.UserService;


@RestController
@RequestMapping("/user")
public class UserAction {

	@Autowired
    private UserService userService;
	@Autowired
    private LoginLogService loginLogService;	
	
	//localhost:8088/springweb/user/login
	//post参数:{name:'tom',password:123}
    @ResponseBody
    @RequestMapping(value="/login",method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8")
    public String login(@RequestBody String json) {
    	User user = JSONObject.parseObject(json, User.class);
    	int count = userService.validate(user);
    	if(count > 0){
    		LoginLog log = new LoginLog();
    		log.setUserid(user.getId());
    		log.setIp("localhost");
    		log.setTime(new Date());
    		loginLogService.insertLog(log);
    		return "success";
    	}else{
    		return "fail";
    	}
    }
    
    //http://localhost:8088/springweb/user/getInfo?name=张三
    @ResponseBody
    @RequestMapping(value="/getInfo",method = RequestMethod.GET,
    	produces = "application/json;charset=UTF-8")
    public String getInfo(String name) {
    	User user = userService.findUserByUsername(name);
        return JSONObject.toJSONString(user);
    }
    
}