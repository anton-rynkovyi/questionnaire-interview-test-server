package com.qit.server.service.user.bo;

import com.qit.server.models.User;
import com.qit.server.repositories.UserRepository;
import com.qit.server.service.AbstractBusinessOperation;
import org.springframework.beans.factory.annotation.Autowired;

public class RegisterNewUserBO extends AbstractBusinessOperation<User> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User internalInvoke(User user) {
        User savedUser = userRepository.save(user);
        return savedUser;
    }
}
