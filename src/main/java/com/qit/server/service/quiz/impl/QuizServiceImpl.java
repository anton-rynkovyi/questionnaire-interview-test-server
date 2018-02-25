package com.qit.server.service.quiz.impl;

import com.qit.server.dao.QuizDao;
import com.qit.server.dto.QitResponse;
import com.qit.server.model.quiz.Quiz;
import com.qit.server.service.quiz.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Deprecated
@Service
public class QuizServiceImpl implements QuizService<Quiz> {

	@Autowired
	private QuizDao quizDao;

	@Override
	public List<Quiz> getAll() {
		return quizDao.findAll();
	}

	@Override
	public Quiz getOne(Long id) {
		return quizDao.findOne(id);
	}

	@Override
	public QitResponse save(Quiz quiz) {
		QitResponse qitResponse = new QitResponse();
		quiz = quizDao.save(quiz);
		if (quiz != null) {
			qitResponse.setId(quiz.getId());
			qitResponse.successed();
		} else {
			qitResponse.failed();
		}

		return qitResponse;
	}

	@Override
	public QitResponse delete(Quiz quiz) {
		QitResponse qitResponse = new QitResponse();
		if (quiz != null) {
			quizDao.delete(quiz);
			qitResponse.setId(quiz.getId());
			qitResponse.successed();
		} else {
			qitResponse.failed();
		}

		return qitResponse;
	}

	@Override
	public QitResponse deleteById(Long id) {
		QitResponse qitResponse = new QitResponse();
		if (id != null) {
			quizDao.delete(id);
			qitResponse.successed();
		} else {
			qitResponse.failed();
		}

		return qitResponse;
	}
}
