package com.avers.dto;

/**
 * Created by GoldBows on 7/9/2015.
 */
public class UserDTO {
    private String username;
    private String password;
    private int userID;

    public UserDTO() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public UserDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }


}
