package com.qit.server.service.user;
import com.qit.server.models.SimpleUser;
import com.qit.server.models.User;
import com.qit.server.models.UserBan;
import com.qit.server.rest.dto.UserCredentialDTO;
import org.springframework.data.authentication.UserCredentials;

import java.util.List;

public interface UserService {

    User findUser(String username);
    User saveUser(User user);
    void removeUser(String username);
    List<User> findAllUsers();

    User authorize(User user);

    UserBan findUserBan(Long banId);
    List<UserBan> findAllUserBans();
    UserBan setBan(UserBan userBan);
    void unban(String username);
    List<User> findAllBannedUsers();
    User findOneBannedUser(String username);

}
