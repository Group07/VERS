package com.avers.dao;


import com.avers.dto.UserDTO;

/**
 * Created by GoldBows on 7/9/2015.
 */
public interface UserDAO {

    public void insertUser(UserDTO user);

    public int getUserID(String userName);
}
