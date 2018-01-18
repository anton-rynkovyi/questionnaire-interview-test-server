package com.qit.server.service.quizzes.quiz.impl;

import com.qit.server.models.Quiz;
import com.qit.server.repositories.QuizRepository;
import com.qit.server.service.quizzes.quiz.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizRepository quizRepository;

    @Override
    public Quiz findQuiz(Long quizId) {
        return quizRepository.findOne(quizId);
    }

    @Override
    public Quiz saveQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public void removeQuiz(Long quizId) {
        quizRepository.delete(quizId);
    }

    @Override
    public List<Quiz> findAllQuizzes() {
        return quizRepository.findAll();
    }
}
