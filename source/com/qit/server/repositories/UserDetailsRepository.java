package com.qit.server.repositories;

import com.qit.server.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepository extends JpaRepository<User, Long>{
}
