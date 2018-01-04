package com.qit.server.controllers.user;

import com.qit.server.models.User;
import com.qit.server.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class CrudUserController {

    private UserService userService;


/*    @RequestMapping(path = "/simple/{username}", method = RequestMethod.GET)
    public SimpleUser getSimpleUser(@PathVariable("username") String username) {
        return userService.getSimpleUser(username);
    }

    @RequestMapping(path = "/simple", method = RequestMethod.GET)
    public List<SimpleUser> getAllSimpleUsers() {
        return userService.getAllSimpleUsers();
    }

    @RequestMapping(path = "/simple", method = RequestMethod.POST)
    public SimpleUser saveSimpleUser(@RequestBody SimpleUser user) {
        return userService.saveSimpleUser(user);
    }

    @RequestMapping(path = "/simple/{username}", method = RequestMethod.DELETE)
    public void removeSimpleUser(@PathVariable("username") String username) {
        userService.removeSimpleUser(username);
    }*/


    @RequestMapping(path = "/{username}", method = RequestMethod.GET)
    public User getUser(@PathVariable("username") String username) {
        return userService.findUser(username);
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public List<User> getAllUsers() {
        return userService.findAllUsers();
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @RequestMapping(path = "/{username}", method = RequestMethod.DELETE)
    public void removeUser(@PathVariable("username") String username) {
        userService.removeUser(username);
    }


    /*==================Autowired==================*/

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
