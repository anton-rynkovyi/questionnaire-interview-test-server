package com.qit.server.service;

import com.qit.server.dao.UserDao;
import com.qit.server.dto.QitResponse;
import com.qit.server.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public List<User> getAllUsers() {
		return null;
	}

	@Override
	public User getUser(Long id) {
		return null;
	}

	@Override
	public QitResponse save(User user) {
		QitResponse qitResponse = new QitResponse();
		if (user != null) {
			user = userDao.save(user);
			qitResponse.setPrimaryKey(user.getLogin());
			qitResponse.successed();
		} else {
			qitResponse.failed();
		}

		return qitResponse;
	}

	@Override
	public QitResponse delete(User user) {
		QitResponse qitResponse = new QitResponse();
		if (user != null) {
			user.setEnabled(false);
			userDao.save(user);
			qitResponse.successed();
		} else {
			qitResponse.failed();
		}

		return qitResponse;
	}
}
