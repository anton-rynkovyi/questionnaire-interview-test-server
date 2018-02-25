package com.qit.server.service.quiz;

import com.qit.server.dto.QitResponse;
import com.qit.server.model.quiz.Questionnaire;
import com.qit.server.model.quiz.Quiz;

import java.util.List;

public interface QuizService<T extends Quiz> {
	List<T> getAll();
	T getOne(Long id);
	QitResponse save(T quiz);
	QitResponse delete(T quiz);
	QitResponse deleteById(Long id);
}
