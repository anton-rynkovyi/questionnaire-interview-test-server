package com.qit.server.service.impl;

import com.qit.server.models.SimpleUser;
import com.qit.server.repositories.SimpleUserRepository;
import com.qit.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SimpleUserRepository simpleUserRepository;


    @Override
    public SimpleUser getSimpleUser(String username) {
        return simpleUserRepository.getOne(username);
    }

    @Override
    public SimpleUser saveSimpleUser(SimpleUser simpleUser) {
        return simpleUserRepository.save(simpleUser);
    }

    @Override
    public void removeSimpleUser(String username) {
        simpleUserRepository.delete(username);
    }

    @Override
    public List<SimpleUser> getAllSimpleUsers() {
        return simpleUserRepository.findAll();
    }
}
