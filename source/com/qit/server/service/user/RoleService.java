package com.qit.server.service.user;

import com.qit.server.models.UserRole;

import java.util.Set;

public interface RoleService {

    void addRoleToUser(String username, UserRole role);
    void removeRoleFromUser(String username, Long roleId);
    Set<UserRole> findRolesByUsername(String username);

}
