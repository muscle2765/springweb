package com.springweb.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.springweb.dto.User;


@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public User findUserByName(final String name) {
        String sql = "select id,name,password from user where name = ?";
        final User user = new User();
        jdbcTemplate.query(sql, new Object[] { name }, new RowCallbackHandler() {
            public void processRow(ResultSet rs) throws SQLException {
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
            }
        });
        return user;
    }

    public void updateLoginInfo(User user) {
        String sql = "update user set name = ? where user_id = ?";
        jdbcTemplate.update(sql,
                new Object[] { user.getName(), user.getId() });
    }
    
    public int validate(User user){
    	String sql = "select * from user where name = ? and password = ?";
    	List<User> t = jdbcTemplate.query(sql, new Object[] { user.getName(), user.getPassword()}, new BeanPropertyRowMapper(User.class));
    	return t.size();
    }
}