package com.qit.server.controllers.user;

import com.qit.server.models.User;
import com.qit.server.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class CrudUserController {

    private UserService userService;


    @RequestMapping(path = "/{username}", method = RequestMethod.GET)
    public ResponseEntity<User> getUser(@PathVariable("username") String username) {
        User user = userService.findUser(username);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.status(HttpStatus.NOT_FOUND).body(user);
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<User> getAllUsers() {
        return userService.findAllUsers();
    }

    @RequestMapping(path = "", method = RequestMethod.POST)
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
