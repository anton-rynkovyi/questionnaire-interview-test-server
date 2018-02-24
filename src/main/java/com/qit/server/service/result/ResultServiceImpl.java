package com.qit.server.service.result;

import com.qit.server.dao.ResultDao;
import com.qit.server.dto.QitResponse;
import com.qit.server.model.quiz.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultServiceImpl implements ResultService {

	@Autowired
	private ResultDao resultDao;

	@Override
	public List<Result> getAllResults() {
		return resultDao.findAll();
	}

	@Override
	public Result getResult(Long id) {
		if (id == null) {
			return null;
		} else {
			return resultDao.getOne(id);
		}
	}

	@Override
	public QitResponse save(Result result) {
		QitResponse qitResponse = new QitResponse();
		if (result == null) {
			qitResponse.failed();
		} else {
			result = resultDao.save(result);
			qitResponse.successed();
			qitResponse.setId(result.getId());
		}
		return qitResponse;
	}

	@Override
	public QitResponse delete(Result result) {
		QitResponse qitResponse = new QitResponse();
		if (result != null) {
			resultDao.delete(result);
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
			resultDao.delete(id);
			qitResponse.successed();
		} else {
			qitResponse.failed();
		}
		return qitResponse;
	}
}
