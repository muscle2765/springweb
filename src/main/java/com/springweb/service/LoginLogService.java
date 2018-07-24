package com.springweb.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springweb.dao.ILoginLogDao;
import com.springweb.dto.LoginLog;


@Service
public class LoginLogService {
    @Autowired
    private ILoginLogDao logDao;

    public void insertLog(LoginLog log) {
        logDao.insertLog(log);
    }
}