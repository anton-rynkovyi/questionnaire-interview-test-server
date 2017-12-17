package com.qit.server.service;

import com.qit.server.models.User;
import com.qit.server.models.UserRole;

import java.util.Set;

public interface UserService {

    User createSimpleUser(User user);

    User createUserWithRoles(User user, Set<UserRole> userRoles);
}
