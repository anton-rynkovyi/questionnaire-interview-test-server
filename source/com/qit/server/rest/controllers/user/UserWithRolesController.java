package com.qit.server.rest.controllers.user;

import com.qit.server.models.User;
import com.qit.server.models.UserRole;
import com.qit.server.rest.dto.user.UserRoleDTO;
import com.qit.server.rest.dto.user.UserWithRolesDTO;
import com.qit.server.service.user.RoleService;
import com.qit.server.service.user.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/users/roles")
public class UserWithRolesController {

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping(path = "/{username}", method = RequestMethod.GET)
    public ResponseEntity<UserWithRolesDTO> findUserWithRoles(@PathVariable("username") String username) {
        User user = userService.findUser(username);
        UserWithRolesDTO userDTO = modelMapper.map(user, UserWithRolesDTO.class);

        return user != null ? ResponseEntity.ok(userDTO) : ResponseEntity.status(HttpStatus.NOT_FOUND).body(userDTO);
    }

    @RequestMapping(path = "", method = RequestMethod.POST)
    public UserWithRolesDTO saveUser(@RequestBody UserWithRolesDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        for (UserRole role : user.getUserRoles()) {
            role.setUser(user);
        }
        userService.saveUser(user);

        return userDTO;
    }

    @RequestMapping(path = "/{username}", method = RequestMethod.DELETE)
    public void removeUser(@PathVariable("username") String username) {
        userService.removeUser(username);
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<UserWithRolesDTO> findAllUsers() {
        List<User> userList = userService.findAllUsers();
        List<UserWithRolesDTO> userDTOs = new ArrayList<UserWithRolesDTO>();

        for (User user : userList) {
            userDTOs.add(modelMapper.map(user, UserWithRolesDTO.class));
        }

        return userDTOs;
    }
}
