package com.qit.server.service.user;

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
		return userDao.findAll();
	}

	@Override
	public User getUser(String login) {
		if (login == null) return null;
		return userDao.getOne(login);
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

	@Override
	public QitResponse deleteByLogin(String login) {
		QitResponse qitResponse = new QitResponse();
		if (login != null) {
			User user = getUser(login);
			user.setEnabled(false);
			userDao.save(user);
			qitResponse.setPrimaryKey(user.getLogin());
			qitResponse.successed();
		} else {
			qitResponse.failed();
		}

		return qitResponse;
	}
}
