package com.qit.server.rest.controllers.quizzes.questionnaire;

import com.qit.server.models.Questionnaire;
import com.qit.server.service.quizzes.questionnaire.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questionnaires")
public class CrudQuestionnaireController {

    @Autowired
    private QuestionnaireService questionnaireService;

    @RequestMapping(path = "/{quizId}", method = RequestMethod.GET)
    public ResponseEntity<Questionnaire> getQuestionnaire(@PathVariable("quizId") Long quizId) {
        Questionnaire questionnaire = questionnaireService.findQuestionnaire(quizId);
        return questionnaire != null ? ResponseEntity.ok(questionnaire) : ResponseEntity.status(HttpStatus.NOT_FOUND).body(questionnaire);
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Questionnaire> getAllQuestionnaires() {
        return questionnaireService.findAllQuestionnaires();
    }

    @RequestMapping(path = "", method = RequestMethod.POST)
    public Questionnaire saveQuestionnaire(@RequestBody Questionnaire questionnaire) {
        return questionnaireService.saveQuestionnaire(questionnaire);
    }

    @RequestMapping(path = "/{quizId}", method = RequestMethod.DELETE)
    public void removeQuestionnaire(@PathVariable("quizId") Long quizId) {
        questionnaireService.removeQuestionnaire(quizId);
    }
}
