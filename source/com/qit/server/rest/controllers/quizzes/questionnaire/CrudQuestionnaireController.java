package com.qit.server.rest.controllers.quizzes.questionnaire;

import com.qit.server.models.QitQuestion;
import com.qit.server.models.Questionnaire;
import com.qit.server.rest.dto.questions.QuestionDTO;
import com.qit.server.rest.dto.quizzes.questionnaire.QuestionnaireDTO;
import com.qit.server.service.question.QuestionService;
import com.qit.server.service.quizzes.questionnaire.QuestionnaireService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/questionnaires")
public class CrudQuestionnaireController {

    @Autowired
    private QuestionnaireService questionnaireService;

    @Autowired
    private ModelMapper modelMapper;


    @RequestMapping(path = "/{quizId}", method = RequestMethod.GET)
    public ResponseEntity<QuestionnaireDTO> findQuestionnaire(@PathVariable("quizId") Long quizId) {
        Questionnaire questionnaire = questionnaireService.findQuestionnaire(quizId);
        QuestionnaireDTO questionnaireDTO = modelMapper.map(questionnaire, QuestionnaireDTO.class);

        return questionnaireDTO != null ? ResponseEntity.ok(questionnaireDTO) : ResponseEntity.status(HttpStatus.NOT_FOUND).body(questionnaireDTO);
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<QuestionnaireDTO> findAllQuestionnaires() {
        List<Questionnaire> allQuestionnaires = questionnaireService.findAllQuestionnaires();
        List<QuestionnaireDTO> questionnaireDTOs = new ArrayList<QuestionnaireDTO>();

        for (Questionnaire questionnaire : allQuestionnaires) {
            questionnaireDTOs.add(modelMapper.map(questionnaire, QuestionnaireDTO.class));
        }

        return questionnaireDTOs;
    }

    @RequestMapping(path = "", method = RequestMethod.POST)
    public QuestionnaireDTO saveQuestionnaire(@RequestBody QuestionnaireDTO questionnaireDTO) {
        questionnaireService.saveQuestionnaire(modelMapper.map(questionnaireDTO, Questionnaire.class));
        return questionnaireDTO;
    }

    @RequestMapping(path = "/{quizId}", method = RequestMethod.DELETE)
    public void removeQuestionnaire(@PathVariable("quizId") Long quizId) {
        questionnaireService.removeQuestionnaire(quizId);
    }
}