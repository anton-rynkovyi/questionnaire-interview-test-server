package com.qit.server.service.user.impl;

import com.qit.server.models.User;
import com.qit.server.repositories.UserRepository;
import com.qit.server.service.AbstractBusinessOperationService;
import com.qit.server.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerNewUser(User user) {
        return userRepository.save(user);
    }
}
