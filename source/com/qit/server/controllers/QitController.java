package com.qit.server.controllers;

import com.qit.server.models.*;
import com.qit.server.repositories.*;
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

    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Autowired
    QuestionRepository qitQuestionRepository;

    @Autowired
    AnswerVariantRepository answerVariantRepository;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public String getQit() {

        FullUser edik = new FullUser();
        edik.setUsername("edik228");
        edik.setPassword("qq123");
        edik.setFirstName("Edik");
        edik.setLastName("Belchik");
        edik.setGender(true);
        edik.setAdditionalInfo("My name is Edik...");
        Set<UserRole> userRoles = new HashSet<UserRole>();
        userRoles.add(new UserRole("ADMIN"));
        userRoles.add(new UserRole("MODERATOR"));
        edik.addUserRoles(userRoles);

        User user = new FullUser();
        user.setUsername("pashka412");
        user.setPassword("passw555");

        userDetailsRepository.save(edik);
        userDetailsRepository.save(user);

        return "Users created!";
    }

    @RequestMapping(value = "/create_quest1", method = RequestMethod.GET)
    @ResponseBody
    public String createQuest() {

        User owner = new FullUser();
        owner.setUsername("anton");
        Set<UserRole> userRoles = new HashSet<UserRole>();
        userRoles.add(new UserRole("ADMIN"));
        userRoles.add(new UserRole("SUPER ADMIN"));
        owner.addUserRoles(userRoles);
        owner.setPassword("qwerty");


        Questionnaire quest = new Questionnaire();
        quest.setTitle("Title");
        quest.setTopic("Topic");
        quest.setOwner(owner);
        quest.setAnonymity(true);
        quest.setPassword("qwerty");
        quest.setResultVisibility(true);
        quest.setStartDate(new Timestamp(System.currentTimeMillis()));

        Questionnaire quest2 = new Questionnaire();
        quest2.setTitle("Title2");
        quest2.setTopic("Topic2");
        quest2.setOwner(owner);
        quest2.setAnonymity(true);
        quest2.setPassword("qwerty222");
        quest2.setResultVisibility(true);
        quest2.setStartDate(new Timestamp(System.currentTimeMillis()-5000));

        Set<Quiz> quizSet = new HashSet<Quiz>();
        quizSet.add(quest);
        quizSet.add(quest2);
        owner.setOwnedQuizzes(quizSet);

        userDetailsRepository.save(owner);
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


    @RequestMapping(value = "/create_quest_questions", method = RequestMethod.GET)
    @ResponseBody
    public String createQuestQuestions() {
        createQuest();
        Questionnaire one = questRepository.getOne(1L);

        QitQuestion qitQuestion = new QitQuestion();
        qitQuestion.setQuiz(one);
        qitQuestion.setSequence(1);
        qitQuestion.setSummary("What is your name?");

        QitQuestion qitQuestion1 = new QitQuestion();
        qitQuestion1.setQuiz(one);
        qitQuestion1.setSequence(2);
        qitQuestion1.setSummary("How old are you?");

        Set<QitQuestion> questionList = new LinkedHashSet<QitQuestion>();
        questionList.add(qitQuestion);
        questionList.add(qitQuestion1);

        AnswerVariant answerVariant1 = new AnswerVariant(qitQuestion,"Anton");
        AnswerVariant answerVariant2 = new AnswerVariant(qitQuestion1,"Edik");
        Set<AnswerVariant> answerVariants = new LinkedHashSet<AnswerVariant>();
        answerVariants.add(answerVariant1);
        answerVariants.add(answerVariant2);
        qitQuestion.setAnswerVariants(answerVariants);
        QitAnswer answer = new QitAnswer(qitQuestion, "nikitka228", answerVariant1.getAnswer());
        Set<QitAnswer> answers = new LinkedHashSet<QitAnswer>();
        answers.add(answer);
        qitQuestion.setQitAnswers(answers);


        qitQuestionRepository.save(questionList);

        Set<QitQuestion> questions = one.getQuestions();
        System.out.println(questions.size());

        return "Questions created!";
    }


    private UserRole setRoleToUser(User user, String roleName) {
        UserRole userRole = new UserRole();
        userRole.setRole(roleName);
        userRole.setUser(userRepository.findOne(user.getUsername()));
        return userRole;
    }
}
