package com.qit.server.service.user.impl;

import com.qit.server.models.SimpleUser;
import com.qit.server.models.User;
import com.qit.server.models.UserRole;
import com.qit.server.repositories.UserRoleRepository;
import com.qit.server.service.user.RoleService;
import com.qit.server.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private UserRoleRepository roleRepository;

    @Autowired
    private UserService userService;


    @Override
    public void addRoleToUser(String username, UserRole role) {
        SimpleUser user = userService.findUser(username);
        if (user != null) {
            role.setUser(user);
            roleRepository.save(role);
        }
    }

    @Override
    public void removeRoleFromUser(String username, Long roleId) {
        SimpleUser user = userService.findUser(username);
        Set<UserRole> userRoles = user.getUserRoles();

        for (UserRole userRole : userRoles) {
            if (userRole.getUserRoleId().equals(roleId)) {
                roleRepository.delete(roleId); //todo don't delete role. need fix.
            }
        }
    }

    @Override
    public Set<UserRole> findRolesByUsername(String username) {
        User user = userService.findUser(username);
        return roleRepository.findRolesByUser(user);
    }

}
