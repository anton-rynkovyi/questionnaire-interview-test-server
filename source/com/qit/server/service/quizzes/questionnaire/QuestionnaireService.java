package com.qit.server.service.quizzes.questionnaire;

import com.qit.server.models.Questionnaire;

import java.util.List;

public interface QuestionnaireService {

    Questionnaire findQuestionnaire(Long quizId);
    Questionnaire saveQuestionnaire(Questionnaire questionnaire);
    void removeQuestionnaire(Long quizId);
    List<Questionnaire> findAllQuestionnaires();

}
