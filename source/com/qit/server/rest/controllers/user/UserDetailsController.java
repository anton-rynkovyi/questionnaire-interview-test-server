package com.qit.server.rest.controllers.user;

import com.qit.server.models.User;
import com.qit.server.rest.dto.user.UserDetailsDTO;
import com.qit.server.service.user.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "api/users/details")
public class UserDetailsController {

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping(path = "/{username}", method = RequestMethod.GET)
    public ResponseEntity<UserDetailsDTO> getUserDetails(@PathVariable("username") String username) {
        User user = userService.findUser(username);
        UserDetailsDTO userDTO = modelMapper.map(user, UserDetailsDTO.class);
        return user != null ? ResponseEntity.ok(userDTO) : ResponseEntity.status(HttpStatus.NOT_FOUND).body(userDTO);
    }

    @RequestMapping(path = "", method = RequestMethod.POST)
    public UserDetailsDTO saveUserDetails(@RequestBody UserDetailsDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        userService.saveUser(user);
        return userDTO;
    }

    @RequestMapping(path = "/{username}", method = RequestMethod.DELETE)
    public void removeUserDetails(@PathVariable("username") String username) {
        userService.removeUser(username);
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<UserDetailsDTO> getAllUsersDetails() {
        List<UserDetailsDTO> userDTOs = new ArrayList<UserDetailsDTO>();
        List<User> userList = userService.findAllUsers();
        for (User user : userList) {
            userDTOs.add(modelMapper.map(user, UserDetailsDTO.class));
        }
        return userDTOs;
    }
}
