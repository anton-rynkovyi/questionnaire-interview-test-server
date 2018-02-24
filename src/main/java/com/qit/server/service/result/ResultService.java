package com.qit.server.service.result;

import com.qit.server.dto.QitResponse;
import com.qit.server.model.quiz.Result;

import java.util.List;

public interface ResultService {
	List<Result> getAllResults();
	Result getResult(Long id);
	QitResponse save(Result result);
	QitResponse delete(Result result);
	QitResponse deleteById(Long id);
}
