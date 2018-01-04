package com.qit.server.service.user.impl;

import com.qit.server.models.SimpleUser;
import com.qit.server.models.User;
import com.qit.server.models.UserBan;
import com.qit.server.repositories.SimpleUserRepository;
import com.qit.server.repositories.UserBanRepository;
import com.qit.server.repositories.UserRepository;
import com.qit.server.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    private SimpleUserRepository simpleUserRepository;
    private UserRepository userRepository;
    private UserBanRepository banRepository;


    /*==============CRUD==============*/

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

    @Override
    public User findUser(String username) {
        return userRepository.findOne(username);
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void removeUser(String username) {
        userRepository.delete(username);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserBan findUserBan(Long banId) {
        return banRepository.findOne(banId);
    }

    @Override
    public List<UserBan> findAllUserBans() {
        return banRepository.findAll();
    }

    @Override
    public UserBan setBan(UserBan userBan) {
        return banRepository.save(userBan);
    }

    @Override
    public void unban(String username) {
        banRepository.deleteUserBansByBanOwnerUsername(username);
    }

    @Override
    public List<User> findAllBannedUsers() {
        return banRepository.findAllBannedUsers();
    }

    @Override
    public User findOneBannedUser(String username) {
        return banRepository.findOneBannedUser(username);
    }


    /*==================Autowired==================*/

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setSimpleUserRepository(SimpleUserRepository simpleUserRepository) {
        this.simpleUserRepository = simpleUserRepository;
    }

    @Autowired
    public void setUserBanRepository(UserBanRepository banRepository) {
        this.banRepository = banRepository;
    }
}
