package com.qit.server.service.quiz;

import com.qit.server.dto.QitResponse;
import com.qit.server.model.quiz.Quiz;

import java.util.List;

public interface QuizService {
	List<Quiz> getAllQuizzes();
	Quiz getQuiz(Long id);
	QitResponse save(Quiz quiz);
	QitResponse delete(Quiz quiz);
	QitResponse deleteById(Long id);
}
