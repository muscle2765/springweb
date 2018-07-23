package com.springweb.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springweb.dao.LoginLogDao;
import com.springweb.dto.LoginLog;


@Service
public class LoginLogService {
    @Autowired
    private LoginLogDao loginLogDao;

    public int insertLog(LoginLog log) {
        return loginLogDao.insertLog(log);
    }
}