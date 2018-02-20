package com.qit.server.service.quiz;

import com.qit.server.dao.QuizDao;
import com.qit.server.dto.QitResponse;
import com.qit.server.model.quiz.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {

	@Autowired
	private QuizDao quizDao;

	@Override
	public List<Quiz> getAllQuizzes() {
		return quizDao.findAll();
	}

	@Override
	public Quiz getQuiz(Long id) {
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
}
