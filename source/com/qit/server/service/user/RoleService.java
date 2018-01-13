package com.qit.server.service.user;

import com.qit.server.models.SimpleUser;
import com.qit.server.models.UserRole;

import java.util.Set;

public interface RoleService {

    void setRoleToUser(SimpleUser user, UserRole role);
    Set<UserRole> findRolesByUser(SimpleUser user);
    void removeRoleFromUser(SimpleUser user, UserRole role);
    UserRole saveUserRoles(UserRole role);

}
