package com.qit.server.service;
import com.qit.server.models.SimpleUser;
import com.qit.server.models.User;

import java.util.List;

public interface UserService {

    SimpleUser getSimpleUser(String username);
    SimpleUser saveSimpleUser(SimpleUser user);
    void removeSimpleUser(String username);
    List<SimpleUser> getAllSimpleUsers();

}
