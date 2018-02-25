package com.qit.server.service.quiz.impl;

import com.qit.server.dao.QuestionnaireDao;
import com.qit.server.dto.QitResponse;
import com.qit.server.model.quiz.Questionnaire;
import com.qit.server.service.quiz.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionnaireServiceImpl implements QuizService<Questionnaire> {

    @Autowired
    private QuestionnaireDao questionnaireDao;

    @Override
    public List<Questionnaire> getAll() {
        return questionnaireDao.findAll();
    }

    @Override
    public Questionnaire getOne(Long id) {
        return questionnaireDao.findOne(id);
    }

    @Override
    public QitResponse save(Questionnaire questionnaire) {
        QitResponse qitResponse = new QitResponse();
        questionnaire = questionnaireDao.save(questionnaire);
        if (questionnaire != null) {
            qitResponse.setId(questionnaire.getId());
            qitResponse.successed();
        } else {
            qitResponse.failed();
        }

        return qitResponse;
    }

    @Override
    public QitResponse delete(Questionnaire questionnaire) {
        QitResponse qitResponse = new QitResponse();
        if (questionnaire != null) {
            questionnaireDao.delete(questionnaire);
            qitResponse.setId(questionnaire.getId());
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
            questionnaireDao.delete(id);
            qitResponse.successed();
        } else {
            qitResponse.failed();
        }

        return qitResponse;
    }
}
