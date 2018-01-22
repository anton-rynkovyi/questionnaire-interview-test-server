package com.qit.server.service.answer.impl;

import com.qit.server.models.QitAnswer;
import com.qit.server.models.QitQuestion;
import com.qit.server.repositories.AnswerRepository;
import com.qit.server.service.answer.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    @Override
    public List<QitAnswer> findAnswersByQuestion(QitQuestion question) {
        return answerRepository.findQitAnswersByQitQuestion(question);
    }

    @Override
    public List<QitAnswer> findAnswersByQuestionId(Long questionId) {
        return answerRepository.findQitAnswersByQitQuestionQuestionId(questionId);
    }

    @Override
    public QitAnswer findAnswer(Long answerId) {
        return answerRepository.findOne(answerId);
    }

    @Override
    public QitAnswer saveAnswer(QitAnswer answer) {
        return answerRepository.saveAndFlush(answer);
    }

    @Override
    public void removeAnswerById(Long answerId) {
        answerRepository.delete(answerId);
    }

    @Override
    public List<QitAnswer> findAllAnswers() {
        return answerRepository.findAll();
    }
}
