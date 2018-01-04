package com.qit.server.controllers.user;


import com.qit.server.models.User;
import com.qit.server.models.UserBan;
import com.qit.server.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users/bans")
public class UserBanController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public List<User> getBannedUsers() {
        return userService.findAllBannedUsers();
    }

    @RequestMapping(value = "/user/{username}", method = RequestMethod.GET)
    public User getBannedUsers(@PathVariable("username") String username) {
        return userService.findOneBannedUser(username);
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
    public UserBan getBannedUsers(@PathVariable("banId") Long banId) {
        return userService.findUserBan(banId);
    }

}
