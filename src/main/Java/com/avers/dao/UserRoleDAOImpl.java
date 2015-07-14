package com.avers.dao;

import com.avers.dto.UserRolesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by Amila on 7/14/2015.
 */
public class UserRoleDAOImpl implements UserRoleDAO {

    @Autowired
    DataSource dataSource;

    @Override
    public void insertRole(UserRolesDTO userRole) {

        String sql = "INSERT INTO user_roles" + "(username,role) VALUES(?,?)";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        jdbcTemplate.update(sql, userRole.getUsername(), userRole.getRole());
    }
}
