package com.qit.server.controllers;

import com.qit.server.models.*;
import com.qit.server.repositories.InterviewRepository;
import com.qit.server.repositories.QuestRepository;
import com.qit.server.repositories.UserRepository;
import com.qit.server.repositories.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.util.*;

@Controller
@RequestMapping("/qit")
public class QitController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserRoleRepository userRoleRepository;

    @Autowired
    QuestRepository questRepository;

    @Autowired
    InterviewRepository interviewRepository;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public String getQit() {

        User user = new User("Edik", "qwerty");

        Set<UserRole> userRoles = new HashSet<UserRole>();
        userRoles.add(new UserRole("ADMIN"));
        userRoles.add(new UserRole("MODERATOR"));
        user.addUserRoles(userRoles);

        UserDetails edikDetails = new UserDetails();
        edikDetails.setEmail("edik@gmail.com");
        edikDetails.setFirstName("Edik");
        edikDetails.setLastName("Belchik");
        edikDetails.setBirthDate(new java.sql.Date(System.currentTimeMillis()));
        user.addUserDetailss(edikDetails);

        userRepository.save(user);

        return userRepository.findOne("Edik").toString();
    }


    @RequestMapping(value = "/create_quest1", method = RequestMethod.GET)
    @ResponseBody
    public String createQuest() {

        User owner = new User();
        owner.setUsername("anton");
        Set<UserRole> userRoles = new HashSet<UserRole>();
        userRoles.add(new UserRole("ADMIN"));
        userRoles.add(new UserRole("SUPER ADMIN"));
        owner.addUserRoles(userRoles);
        owner.setPassword("qwerty");


        Questionnaire quest = new Questionnaire();
        quest.setTitle("Title");
        quest.setTopic("Topic");
//        quest.setOwner(owner);
        quest.setAnonymity(true);
        quest.setPassword("qwerty");
        quest.setResultVisibility(true);
        quest.setStartDate(new Timestamp(System.currentTimeMillis()));

        Questionnaire quest2 = new Questionnaire();
        quest2.setTitle("Title2");
        quest2.setTopic("Topic2");
//        quest.setOwner(owner);
        quest2.setAnonymity(true);
        quest2.setPassword("qwerty222");
        quest2.setResultVisibility(true);
        quest2.setStartDate(new Timestamp(System.currentTimeMillis()-5000));

        Set<Quiz> quizSet = new HashSet<Quiz>();
        quizSet.add(quest);
        quizSet.add(quest2);
        owner.setOwnedQuezzes(quizSet);

        userRepository.save(owner);
        questRepository.save(quest);
        questRepository.save(quest2);

        return "Quest created!";
    }


    @RequestMapping(value = "/create_interview1", method = RequestMethod.GET)
    @ResponseBody
    public String createInterview() {

        User anton = userRepository.getOne("anton");

        Interview interview = new Interview();
        interview.setPassword("int123");
        interview.setOwner(anton);
        interview.setTitle("Interview title");
        interview.setTopic("Interview topic");
        interview.setResultVisibility(false);


        interviewRepository.save(interview);

        return "Interview created!";
    }

    private User createUser(String username, String password) {
        User user = new User(username,password);
        return user;
    }

    private UserRole setRoleToUser(User user, String roleName) {
        UserRole userRole = new UserRole();
        userRole.setRole(roleName);
        userRole.setUser(userRepository.findOne(user.getUsername()));
        return userRole;
    }
}
