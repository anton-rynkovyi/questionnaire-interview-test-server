package com.qit.server.service.user.impl;

import com.qit.server.models.User;
import com.qit.server.models.UserBan;
import com.qit.server.repositories.UserBanRepository;
import com.qit.server.repositories.UserRepository;
import com.qit.server.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    private UserRepository userRepository;
    private UserBanRepository banRepository;


    /*==============CRUD==============*/

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
        List<User> users = new ArrayList<User>();
        List<UserBan> userBans = banRepository.findAll();

        for (UserBan userBan : userBans) {
            User bannedUser = userRepository.findOne(userBan.getBannedUserUsername());
            users.add(bannedUser);
        }
        return users;
    }

    @Override
    public User findOneBannedUser(String username) {
        UserBan bannedUser = banRepository.findUserBanByBannedUserUsername(username);
        return bannedUser != null ? userRepository.findOne(bannedUser.getBannedUserUsername()) : new User();
    }



    /*==================Autowired==================*/

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setUserBanRepository(UserBanRepository banRepository) {
        this.banRepository = banRepository;
    }
}
