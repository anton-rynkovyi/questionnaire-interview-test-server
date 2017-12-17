package com.qit.server.repositories;

import com.qit.server.models.User;
import com.qit.server.models.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigInteger;
import java.util.Set;

public interface UserRoleRepository extends JpaRepository<UserRole, BigInteger> {

//    @Query(value = "SELECT * FROM user_roles WHERE username = ?1", nativeQuery = true)
    Set<UserRole> findUserRolesByUser(User username);
}
