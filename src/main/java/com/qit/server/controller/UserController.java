package com.qit.server.controller;

import com.qit.server.dto.QitResponse;
import com.qit.server.model.user.User;
import com.qit.server.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@RequestMapping(value = "/{login}", method = RequestMethod.GET)
	public User getUser(@PathVariable("login") String login) {
		return userService.getUser(login);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<QitResponse> saveUser(@RequestBody User user) {
		return new ResponseEntity<>(userService.save(user), HttpStatus.OK);
	}

	@RequestMapping(value = "/{login}", method = RequestMethod.DELETE)
	public ResponseEntity<QitResponse> deleteUser(@PathVariable("login") String login) {
		return new ResponseEntity<>(userService.deleteByLogin(login), HttpStatus.OK);
	}

}
