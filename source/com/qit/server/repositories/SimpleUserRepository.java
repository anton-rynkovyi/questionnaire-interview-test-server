package com.qit.server.repositories;

import com.qit.server.models.SimpleUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SimpleUserRepository extends JpaRepository<SimpleUser, String> {
}
