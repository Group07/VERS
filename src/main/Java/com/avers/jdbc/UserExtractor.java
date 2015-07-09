package com.avers.jdbc;

import com.avers.dto.UserDTO;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by GoldBows on 7/9/2015.
 */
public class UserExtractor implements ResultSetExtractor<UserDTO> {

    public UserDTO extractData(ResultSet resultSet) throws SQLException,
            DataAccessException {

        UserDTO user = new UserDTO();

        user.setUsername(resultSet.getString(1));
        user.setPassword(resultSet.getString(2));

        return user;
    }
}
