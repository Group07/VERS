package com.avers.dto;

/**
 * Created by Amila on 7/14/2015.
 */
public class UserRolesDTO {

    public String role;

    public String username;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserRolesDTO(String role, String username) {
        this.role = role;
        this.username = username;
    }

    public UserRolesDTO() {
    }
}

