package com.avers.services;

import com.avers.dao.UserDAO;
import com.avers.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by GoldBows on 7/9/2015.
 */
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;
    @Override
    public void insertData(UserDTO user) {
        userDAO.insertData(user);
    }
}
