package com.qit.server.rest.dto;

import java.util.Set;

public class UserWithRolesDTO extends UserCredentialDTO {

    private Set<UserRoleDTO> userRoles;

    public Set<UserRoleDTO> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRoleDTO> userRoles) {
        this.userRoles = userRoles;
    }
}
