package com.qit.server.controllers;

import com.qit.server.models.User;
import com.qit.server.models.SimpleUser;
import com.qit.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/{username}", method = RequestMethod.GET)
    public SimpleUser getUser(@PathVariable("username") String username) {
        return userService.getSimpleUser(username);
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public List<SimpleUser> getAllUsers() {
        return userService.getAllSimpleUsers();
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public SimpleUser saveUser(@RequestBody User user) {
        return userService.saveSimpleUser(user);
    }

    @RequestMapping(path = "/{username}", method = RequestMethod.DELETE)
    public void removeUser(@PathVariable("username") String username) {
        userService.removeSimpleUser(username);
    }

}
