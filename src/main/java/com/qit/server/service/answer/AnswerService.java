package com.qit.server.service.answer;

import com.qit.server.dto.QitResponse;
import com.qit.server.model.answer.Answer;

public interface AnswerService {
	Answer getAnswer(Long id);
	QitResponse save(Answer answer);
	QitResponse delete(Answer answer);
}
