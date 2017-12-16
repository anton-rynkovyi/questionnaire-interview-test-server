package com.qit.server.controllers;

import com.qit.server.models.User;
import com.qit.server.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/qit")
public class QitController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public @ResponseBody String getQit() {
        User user = new User();
        user.setUsername("anton");
        user.setPassword("123");

        List<User> all = userRepository.findAll();

        System.out.println(all);

        return "Qit returned";
    }


    private User createUser() {
        User user = new User("anton", "123");
        return user;
    }
}
