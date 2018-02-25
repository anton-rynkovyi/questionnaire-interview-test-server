package com.qit.server.service.quiz.impl;

import com.qit.server.dao.InterviewDao;
import com.qit.server.dto.QitResponse;
import com.qit.server.model.quiz.Interview;
import com.qit.server.service.quiz.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterviewServiceImpl implements QuizService<Interview> {

    @Autowired
    private InterviewDao interviewDao;

    @Override
    public List<Interview> getAll() {
        return interviewDao.findAll();
    }

    @Override
    public Interview getOne(Long id) {
        return interviewDao.findOne(id);
    }

    @Override
    public QitResponse save(Interview interview) {
        QitResponse qitResponse = new QitResponse();
        interview = interviewDao.save(interview);
        if (interview != null) {
            qitResponse.setId(interview.getId());
            qitResponse.successed();
        } else {
            qitResponse.failed();
        }

        return qitResponse;
    }

    @Override
    public QitResponse delete(Interview interview) {
        QitResponse qitResponse = new QitResponse();
        if (interview != null) {
            interviewDao.delete(interview);
            qitResponse.setId(interview.getId());
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
            interviewDao.delete(id);
            qitResponse.successed();
        } else {
            qitResponse.failed();
        }

        return qitResponse;
    }
}
