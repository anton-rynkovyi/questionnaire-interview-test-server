package com.qit.server.rest.dto;

public class UserRoleDTO {

    private Long userRoleId;
    private String role;

    public UserRoleDTO() {
    }

    public Long getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Long userRoleId) {
        this.userRoleId = userRoleId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
