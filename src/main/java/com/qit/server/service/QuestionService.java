package com.qit.server.service;

import com.qit.server.dto.QitResponse;
import com.qit.server.model.question.Question;

import java.util.List;

public interface QuestionService {
	List<Question> getAllQuestion();
	Question getQuestion(Long id);
	QitResponse saveQuestion(Question question);
	QitResponse deleteQuestion(Question question);
}
