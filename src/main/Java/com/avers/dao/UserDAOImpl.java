package com.avers.dao;

import com.avers.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by GoldBows on 7/9/2015.
 */
public class UserDAOImpl implements UserDAO {
    @Autowired
    DataSource dataSource;

    public void insertData(UserDTO user) {
        String sql = "INSERT INTO users" + "(username,password) VALUES(?,?)";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        jdbcTemplate.update(sql, user.getUsername(), user.getPassword());


    }
}
