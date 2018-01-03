package com.qit.server.controllers;


import com.qit.server.models.FullUser;
import com.qit.server.models.User;
import com.qit.server.service.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/qit")
public class QitController {

    @Autowired
    UserServiceImpl userService;

    @RequestMapping(value = "/register_user", method = RequestMethod.GET)
    @ResponseBody
    public String registerUser() {
        User user = new FullUser();
        user.setUsername("rynkovoy");
        user.setPassword("qwerty");

        userService.registerNewUser(user);
        return "User registered";
    }
}
