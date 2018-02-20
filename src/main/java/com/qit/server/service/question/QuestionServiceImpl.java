package com.qit.server.service.question;

import com.qit.server.dao.QuestionDao;
import com.qit.server.dto.QitResponse;
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
		return questionDao.findOne(id);
	}

	@Override
	public QitResponse saveQuestion(Question question) {
		QitResponse qitResponse = new QitResponse();
		if (question == null) {
			qitResponse.failed();
		} else {
			question = questionDao.save(question);
			qitResponse.successed();
			qitResponse.setId(question.getId());
		}
		return qitResponse;
	}

	@Override
	public QitResponse deleteQuestion(Question question) {
		questionDao.delete(question);
		QitResponse qitResponse = new QitResponse();
		qitResponse.successed();
		qitResponse.setId(question.getId());
		return qitResponse;
	}
}
