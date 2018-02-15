package com.qit.server.service.answer;

import com.qit.server.models.QitAnswer;
import com.qit.server.models.QitQuestion;

import java.util.List;

public interface AnswerService {

    List<QitAnswer> findAnswersByQuestion(QitQuestion question);
    List<QitAnswer> findAnswersByQuestionId(Long questionId);
    QitAnswer findAnswer(Long answerId);
    QitAnswer saveAnswer(QitAnswer answer);
    void removeAnswerById(Long answerId);
    List<QitAnswer> findAllAnswers();
}
