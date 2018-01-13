package com.qit.server.rest.controllers.user;

import com.qit.server.models.User;
import com.qit.server.repositories.UserRepository;
import com.qit.server.rest.dto.user.UserCredentialDTO;
import com.qit.server.service.user.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user-credentials")
public class UserCredentialController {

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;


    @RequestMapping(path = "/{username}", method = RequestMethod.GET)
    public ResponseEntity<UserCredentialDTO> findUserCredentials(@PathVariable("username") String username) {
        User user = userService.findUser(username);
        UserCredentialDTO userDTO = modelMapper.map(user, UserCredentialDTO.class);
        return user != null ? ResponseEntity.ok(userDTO) : ResponseEntity.status(HttpStatus.NOT_FOUND).body(userDTO);
    }

    @RequestMapping(path = "", method = RequestMethod.POST)
    public UserCredentialDTO saveUserCredentials(@RequestBody UserCredentialDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        userService.saveUser(user);
        return userDTO;
    }

    @RequestMapping(path = "/{username}", method = RequestMethod.DELETE)
    public void removeUserCredentials(@PathVariable("username") String username) {
        userService.removeUser(username);
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<UserCredentialDTO> findAllUserCredentials() {
        List<UserCredentialDTO> userDTOs = new ArrayList<UserCredentialDTO>();
        List<User> userList = userService.findAllUsers();
        for (User user : userList) {
            userDTOs.add(modelMapper.map(user, UserCredentialDTO.class));
        }
        return userDTOs;
    }

}
