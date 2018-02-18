package com.qit.server.service;

import com.qit.server.dao.QuestionDao;
import com.qit.server.dto.Response;
import com.qit.server.model.question.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionDao questionDao;

	@Override
	public List<Question> getAllQuestion() {
		return null;
	}

	@Override
	public Question getQuestion(Long id) {
		return null;
	}

	@Override
	public Response createQuestion(Question question) {
		return null;
	}

	@Override
	public Response updateQuestion(Question question) {
		return null;
	}

	@Override
	public Response deleteQuestion(Question question) {
		return null;
	}
}
