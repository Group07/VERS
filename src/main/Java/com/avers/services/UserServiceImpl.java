package com.avers.services;

import com.avers.dao.UserDAO;
import com.avers.dao.UserRoleDAO;
import com.avers.dto.UserDTO;
import com.avers.dto.UserRolesDTO;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by GoldBows on 7/9/2015.
 */
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDao;

    @Autowired
    UserRoleDAO userRoleDAO;

    @Override
    public void insertUser(UserDTO user) {
        userDao.insertUser(user);
    }

    @Override
    public void insertUserRole(UserRolesDTO userRolesDTO) {
        userRoleDAO.insertRole(userRolesDTO);
    }
}
