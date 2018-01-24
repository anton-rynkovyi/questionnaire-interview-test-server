package com.qit.server.rest.controllers;


import com.qit.server.models.User;
import com.qit.server.models.UserBan;
import com.qit.server.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users/bans")
public class UserBanController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public List<User> getAllBannedUsers() {
        return userService.findAllBannedUsers();
    }

    @RequestMapping(value = "/user/{username}", method = RequestMethod.GET)
    public ResponseEntity<User> getBannedUser(@PathVariable("username") String username) {
        User oneBannedUser = userService.findOneBannedUser(username);
        if (oneBannedUser == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(oneBannedUser);
        }

        return ResponseEntity.ok(oneBannedUser);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public UserBan setBan(@RequestBody UserBan userBan) {
        return userService.setBan(userBan);
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.DELETE)
    public void unban(@PathVariable("username") String username) {
        userService.unban(username);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<UserBan> getAllUserBans() {
        return userService.findAllUserBans();
    }

    @RequestMapping(value = "/{banId}", method = RequestMethod.GET)
    public UserBan getUserBan(@PathVariable("banId") Long banId) {
        return userService.findUserBan(banId);
    }

}
