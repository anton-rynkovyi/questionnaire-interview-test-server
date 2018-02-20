package com.qit.server.service.result;

import com.qit.server.dto.QitResponse;
import com.qit.server.model.quiz.Result;

public interface ResultService {
	Result getResult(Long id);
	QitResponse save(Result result);
	QitResponse delete(Result result);
}
