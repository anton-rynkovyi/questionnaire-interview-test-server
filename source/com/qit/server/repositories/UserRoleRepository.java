package com.qit.server.repositories;

import com.qit.server.models.SimpleUser;
import com.qit.server.models.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.Set;

public interface UserRoleRepository extends JpaRepository<UserRole, BigInteger> {

//    @Query(value = "SELECT * FROM user_roles WHERE username = ?1", nativeQuery = true)
    Set<UserRole> findRolesByUser(SimpleUser user);

}
