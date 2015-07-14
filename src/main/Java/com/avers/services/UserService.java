package com.avers.services;

import com.avers.dto.UserDTO;
import com.avers.dto.UserRolesDTO;

/**
 * Created by GoldBows on 7/9/2015.
 */
public interface UserService {
    void insertUser(UserDTO user);
    void insertUserRole(UserRolesDTO userRolesDTO);
}
