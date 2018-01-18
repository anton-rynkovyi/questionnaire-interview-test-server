package com.qit.server.service.question;

import com.qit.server.models.QitQuestion;

import java.util.List;

public interface QuestionService {

    QitQuestion findQuestion(Long questionId);
    QitQuestion saveQuestion(QitQuestion question);
    void removeQuestion(Long questionId);
    List<QitQuestion> findAllQuestions(Long quizId);
}
