package com.springweb.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springweb.dao.ILoginLogDao;
import com.springweb.dto.LoginLog;
import com.springweb.service.ILoginLogService;


@Service
public class LoginLogServiceImpl implements ILoginLogService{
    @Autowired
    private ILoginLogDao logDao;

    @Override
    public void insertLog(LoginLog log) {
        logDao.insertLog(log);
    }
}