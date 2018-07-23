package com.springweb.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springweb.dto.LoginLog;

@Repository
public class LoginLogDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int insertLog(LoginLog log) {        
        String sql = "insert into login_log (userid, ip,time) values (?,?,?)";
        return jdbcTemplate.update(sql,
                new Object[] { log.getUserid(), log.getIp(), log.getTime() });
    }

    public List<LoginLog> getLog() {
        String sql = "select * from login_log";
        return jdbcTemplate.queryForList(sql, LoginLog.class);
    }
}