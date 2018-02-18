package com.qit.server.service;

import com.qit.server.dto.Response;
import com.qit.server.model.question.Question;

import java.util.List;

public interface QuestionService {
	List<Question> getAllQuestion();
	Question getQuestion(Long id);
	Response createQuestion(Question question);
	Response updateQuestion(Question question);
	Response deleteQuestion(Question question);
}
