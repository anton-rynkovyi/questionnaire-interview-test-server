package com.qit.server.service.quizzes.questionnaire.impl;

import com.qit.server.models.Questionnaire;
import com.qit.server.repositories.QuestRepository;
import com.qit.server.service.quizzes.questionnaire.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionnaireServiceImpl implements QuestionnaireService {

    private QuestRepository questRepository;

    /*==============CRUD==============*/

    @Override
    public Questionnaire findQuestionnaire(Long quizId) {
        return questRepository.findOne(quizId);
    }

    @Override
    public Questionnaire saveQuestionnaire(Questionnaire questionnaire) {
        return questRepository.save(questionnaire);
    }

    @Override
    public void removeQuestionnaire(Long quizId) {
        questRepository.delete(quizId);
    }

    @Override
    public List<Questionnaire> findAllQuestionnaires() {
        return questRepository.findAll();
    }

    /*==================Autowired==================*/

    @Autowired
    public void setQuestRepository(QuestRepository questRepository) {
        this.questRepository = questRepository;
    }
}
