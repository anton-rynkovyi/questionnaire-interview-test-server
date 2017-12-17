package com.qit.server.controllers;

import com.qit.server.models.User;
import com.qit.server.models.UserDetails;
import com.qit.server.models.UserRole;
import com.qit.server.repositories.UserRepository;
import com.qit.server.repositories.UserRoleRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigInteger;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/qit")
public class QitController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserRoleRepository userRoleRepository;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public String getQit() {

        User user = new User("Edik", "qwerty");
        Set<UserRole> userRoles = new HashSet<UserRole>();
//        userRoles.add(new UserRole(user,"ADMIN"));
//        userRoles.add(new UserRole(user,"MODERATOR"));
        userRoles.add(new UserRole("ADMIN"));
        userRoles.add(new UserRole("MODERATOR"));
        user.setUserRoles(userRoles);

        userRepository.save(user);
//        userRoleRepository.save(userRoles);

        UserDetails edikDetails = new UserDetails();
        edikDetails.setEmail("edik@gmail.com");
        edikDetails.setFirstName("Edik");
        edikDetails.setLastName("Belchik");
        edikDetails.setBirthDate(new java.sql.Date(System.currentTimeMillis()));

        return userRepository.findOne("Edik").toString();
    }


    private User createUser(String username, String password) {
        User user = new User(username,password);
        return user;
    }

    private UserRole setRoleToUser(User user, String roleName) {
        UserRole userRole = new UserRole();
        userRole.setRole(roleName);
        userRole.setUser(userRepository.findOne(user.getUsername()));
        return userRole;
    }
}
