package com.qit.server.repositories;

import com.qit.server.models.SimpleUser;
import com.qit.server.models.User;
import com.qit.server.models.UserBan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.Convert;
import java.util.List;

public interface UserBanRepository extends JpaRepository<UserBan, Long> {

    @Query(value = "" +
            "SELECT u.password, u.enabled, ud.* " +
            "  FROM user_details ud" +
            "  JOIN users u " +
            "    ON ud.username = u.username" +
            "  JOIN user_bans ub" +
            "    ON ud.username = ub.banned_user_username",
            nativeQuery = true)
    List<User> findAllBannedUsers();

    @Query(value = "" +
            "SELECT u.password, u.enabled, ud.* " +
            "  FROM user_details ud" +
            "  JOIN users u " +
            "    ON ud.username = u.username " +
            "  JOIN user_bans ub" +
            "    ON ud.username = ub.banned_user_username " +
            " WHERE ub.banned_user_username = ?1",
            nativeQuery = true)
    User findOneBannedUser(String username);

    @Query(value = "" +
            "SELECT u.*" +
            "  FROM users u, user_bans ub" +
            " where u.username = ub.banned_user_username",
            nativeQuery = true)
    List<SimpleUser> findSU();

    void deleteUserBansByBanOwnerUsername(String username);
}
