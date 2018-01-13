package com.qit.server.service.user.impl;

import com.qit.server.models.SimpleUser;
import com.qit.server.models.UserRole;
import com.qit.server.repositories.UserRoleRepository;
import com.qit.server.service.user.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private UserRoleRepository roleRepository;

    @Override
    public void setRoleToUser(SimpleUser user, UserRole role) {
        Set<UserRole> userRoles = user.getUserRoles();
        userRoles.add(role);
        roleRepository.save(userRoles);
    }

    @Override
    public Set<UserRole> findRolesByUser(SimpleUser user) {
        return roleRepository.findRolesByUser(user);
    }

    @Override
    public void removeRoleFromUser(SimpleUser user, UserRole role) {
        Set<UserRole> userRoles = user.getUserRoles();
        if (userRoles.contains(role)) {
            userRoles.remove(role);
            roleRepository.save(userRoles);
        }
    }

    @Override
    public UserRole saveUserRoles(UserRole role) {
        roleRepository.save(role);
        return role;
    }
}
