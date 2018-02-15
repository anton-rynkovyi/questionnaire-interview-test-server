package com.qit.server.service.question.impl;

import com.qit.server.models.QitQuestion;
import com.qit.server.models.Quiz;
import com.qit.server.repositories.QuestionRepository;
import com.qit.server.service.question.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public List<QitQuestion> findQuestionsByQuiz(Quiz quiz) {
        return questionRepository.findQitQuestionsByQuiz(quiz);
    }

    @Override
    public List<QitQuestion> findQuestionsByQuizId(Long questionId) {
        return questionRepository.findQitQuestionsByQuizQuizId(questionId);
    }

    @Override
    public QitQuestion findQuestionById(Long questionId) {
        return questionRepository.findQitQuestionByQuestionId(questionId);
    }

    @Override
    public QitQuestion saveQuestion(QitQuestion question) {
        return questionRepository.save(question);
    }

    @Override
    public void removeQuestionById(Long questionId) {
        questionRepository.removeById(questionId);
    }

    @Override
    public List<QitQuestion> findAllQuestions() {
        return questionRepository.findAll();
    }

}
