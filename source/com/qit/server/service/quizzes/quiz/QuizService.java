package com.qit.server.service.quizzes.quiz;

import com.qit.server.models.Quiz;

import java.util.List;

public interface QuizService {

    Quiz findQuiz(Long quizId);
    Quiz saveQuiz(Quiz quiz);
    void removeQuiz(Long quizId);
    List<Quiz> findAllQuizzes();
}
