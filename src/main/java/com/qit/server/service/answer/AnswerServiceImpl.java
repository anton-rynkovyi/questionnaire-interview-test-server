package com.qit.server.service.answer;

import com.qit.server.dao.AnswerDao;
import com.qit.server.dto.QitResponse;
import com.qit.server.model.answer.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {

	@Autowired
	private AnswerDao answerDao;

	@Override
	public List<Answer> getAllAnswers() {
		return answerDao.findAll();
	}

	@Override
	public Answer getAnswer(Long id) {
		if (id == null) {
			return null;
		} else {
			return answerDao.getOne(id);
		}
	}

	@Override
	public QitResponse save(Answer answer) {
		QitResponse qitResponse = new QitResponse();
		if (answer != null) {
			answer = answerDao.save(answer);
			qitResponse.successed();
			qitResponse.setId(answer.getId());
		} else {
			qitResponse.failed();
		}
		return qitResponse;
	}

	@Override
	public QitResponse delete(Answer answer) {
		QitResponse qitResponse = new QitResponse();
		if (answer != null) {
			answerDao.delete(answer);
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
			answerDao.delete(id);
			qitResponse.successed();
		} else {
			qitResponse.failed();
		}
		return qitResponse;
	}
}
