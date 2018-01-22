package com.qit.server.service.question;

import com.qit.server.models.QitQuestion;
import com.qit.server.models.Quiz;

import java.util.List;
import java.util.Set;

public interface QuestionService {

    List<QitQuestion> findQuestionsByQuiz(Quiz quiz);
    List<QitQuestion> findQuestionsByQuizId(Long questionId);
    QitQuestion findQuestionById(Long questionId);
    QitQuestion saveQuestion(QitQuestion question);
    void removeQuestionById(Long questionId);
    List<QitQuestion> findAllQuestions();

}
