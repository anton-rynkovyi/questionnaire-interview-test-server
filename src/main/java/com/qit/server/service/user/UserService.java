package com.qit.server.service.user;

import com.qit.server.dto.QitResponse;
import com.qit.server.model.user.User;

import java.util.List;

public interface UserService {
	List<User> getAllUsers();
	User getUser(String login);
	QitResponse save(User user);
	QitResponse delete(User user);
	QitResponse deleteByLogin(String login);
}
