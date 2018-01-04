package com.qit.server.service.user;
import com.qit.server.models.SimpleUser;
import com.qit.server.models.User;
import com.qit.server.models.UserBan;

import java.util.List;

public interface UserService {

    SimpleUser getSimpleUser(String username);
    SimpleUser saveSimpleUser(SimpleUser user);
    void removeSimpleUser(String username);
    List<SimpleUser> getAllSimpleUsers();

    User findUser(String username);
    User saveUser(User user);
    void removeUser(String username);
    List<User> findAllUsers();

    UserBan findUserBan(Long banId);
    List<UserBan> findAllUserBans();
    UserBan setBan(UserBan userBan);
    void unban(String username);
    List<User> findAllBannedUsers();
    User findOneBannedUser(String username);

}
