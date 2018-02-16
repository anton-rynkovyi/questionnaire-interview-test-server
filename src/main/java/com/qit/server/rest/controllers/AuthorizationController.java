package com.qit.server.rest.controllers;


import com.qit.server.models.User;
import com.qit.server.rest.dto.UserCredentialDTO;
import com.qit.server.service.user.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/authorization")
public class AuthorizationController {


    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping(path = "", method = RequestMethod.POST)
    public UserCredentialDTO authorize(@RequestBody UserCredentialDTO userCredentialDTO) {
        User user = modelMapper.map(userCredentialDTO, User.class);
        User authorizedUser = userService.authorize(user);
        if (authorizedUser == null) {
            return null;
        }
        userCredentialDTO.setEnabled(authorizedUser.getEnabled());
        return userCredentialDTO;
    }

}
