package tests.controllers;

import com.qit.server.controller.UserController;
import com.qit.server.dto.QitResponse;
import com.qit.server.model.user.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import tests.AbstractTest;

import java.util.List;

public class UserControllerTest extends AbstractTest {

	@Autowired
	private UserController userController;

	@Test
	public void getAllUsers() {
		newUser();
		List<User> users = userController.getAllUsers();
		Assert.assertNotNull(users);
		Assert.assertFalse(users.isEmpty());
	}

	@Test
	public void getUser() {
		ResponseEntity<QitResponse> responseEntity = newUser();
		Assert.assertNotNull(userController.getUser(responseEntity.getBody().getPrimaryKey()));
	}

	@Test
	public void saveUser() {
		ResponseEntity<QitResponse> responseEntity = newUser();
		Assert.assertTrue(responseEntity.getBody().isSuccessfully());
	}

	@Test
	public void deleteUser() {
		ResponseEntity<QitResponse> responseEntity = newUser();
		responseEntity = userController.deleteUser(responseEntity.getBody().getPrimaryKey());
		User user = userController.getUser(responseEntity.getBody().getPrimaryKey());
		Assert.assertFalse(user.isEnabled());
	}

	private ResponseEntity<QitResponse> newUser() {
		User user = new User();
		user.setLogin("login");
		user.setPassword("password");
		return userController.saveUser(user);
	}

}
