package com.avers.dao;

import com.avers.Utils.encryption.PasswordEncoderGenerator;
import com.avers.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by GoldBows on 7/9/2015.
 */
public class UserDAOImpl implements UserDAO {

    @Autowired
    DataSource dataSource;

    public void insertUser(UserDTO user) {

        String encryptedPassword = PasswordEncoderGenerator.bCrypt(user.getPassword(), 11);

        String sql = "INSERT INTO users" + "(username,password) VALUES(?,?)";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        jdbcTemplate.update(sql, user.getUsername(), encryptedPassword);


    }

    public int getUserID(String userName) {
        //testing JDBC
        String sql = "select user_id from  users where username =" + "'" + userName + "'";
        List<UserDTO> userDTOs = new ArrayList<UserDTO>();

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        for (Map row : rows) {
            UserDTO userDTO = new UserDTO();
            userDTO.setUserID((Integer) row.get("user_id"));
            userDTOs.add(userDTO);
        }

        int userID = userDTOs.get(0).getUserID();

        return userID;
    }
}
