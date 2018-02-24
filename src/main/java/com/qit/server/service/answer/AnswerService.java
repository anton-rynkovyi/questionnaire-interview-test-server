package com.qit.server.service.answer;

import com.qit.server.dto.QitResponse;
import com.qit.server.model.answer.Answer;

import java.util.List;

public interface AnswerService {
	List<Answer> getAllAnswers();
	Answer getAnswer(Long id);
	QitResponse save(Answer answer);
	QitResponse delete(Answer answer);
	QitResponse deleteById(Long id);
}
