package com.qit.server.models;

import java.math.BigInteger;

public class UserRole {

    private BigInteger userRoleId;
    private String username;
    String role;


    public BigInteger getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(BigInteger userRoleId) {
        this.userRoleId = userRoleId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "userRoleId=" + userRoleId +
                ", username='" + username + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
