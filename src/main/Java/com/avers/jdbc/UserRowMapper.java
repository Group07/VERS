package com.avers.jdbc;

import com.avers.dto.UserDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by GoldBows on 7/9/2015.
 */
public class UserRowMapper implements RowMapper<UserDTO> {

    @Override
    public UserDTO mapRow(ResultSet resultSet, int line) throws SQLException {
        UserExtractor userExtractor = new UserExtractor();
        return userExtractor.extractData(resultSet);
    }
}
