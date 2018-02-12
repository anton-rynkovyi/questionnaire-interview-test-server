package com.qit.server.repositories;

import com.qit.server.models.User;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, String> {

    User findUserByUsernameAndPassword(String username, String password);
}
