package com.qit.server.rest.controllers.user;

import com.qit.server.models.UserRole;
import com.qit.server.rest.dto.user.UserRoleDTO;
import com.qit.server.service.user.RoleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/users/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private ModelMapper modelMapper;


    @RequestMapping(path = "/{username}", method = RequestMethod.POST)
    public void addRoleFromUser(@PathVariable("username") String username, @RequestBody UserRoleDTO roleDTO) {
        UserRole role = modelMapper.map(roleDTO, UserRole.class);
        roleService.addRoleToUser(username, role);
    }

    @RequestMapping(path = "/{username}/{roleId}", method = RequestMethod.DELETE)
    public void removeRoleToUser(@PathVariable("username") String username, @PathVariable("roleId") Long roleId) {
        roleService.removeRoleFromUser(username, roleId);
    }

    @RequestMapping(path = "/{username}", method = RequestMethod.GET)
    List<UserRoleDTO> findRolesByUsername(@PathVariable("username") String username) {
        Set<UserRole> userRoles = roleService.findRolesByUsername(username);
        List<UserRoleDTO> roleDTOs = new ArrayList<UserRoleDTO>();

        for (UserRole role : userRoles) {
            roleDTOs.add(modelMapper.map(role, UserRoleDTO.class));
        }

        return roleDTOs;
    }
}
