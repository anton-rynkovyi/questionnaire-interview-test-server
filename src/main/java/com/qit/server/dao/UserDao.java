package com.qit.server.dao;

import com.qit.server.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Arizel on 18.02.2018.
 */
public interface UserDao extends JpaRepository<User, Long> {
}
