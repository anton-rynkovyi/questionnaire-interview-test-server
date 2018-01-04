package com.qit.server.repositories;

import com.qit.server.models.SimpleUser;
import com.qit.server.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SimpleUserRepository extends JpaRepository<SimpleUser, String> {

}
