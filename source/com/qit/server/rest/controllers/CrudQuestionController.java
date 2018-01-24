package com.qit.server.rest.controllers;

import com.qit.server.models.QitQuestion;
import com.qit.server.rest.dto.QuestionDTO;
import com.qit.server.service.question.QuestionService;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/api/questions")
public class CrudQuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<QuestionDTO> findQuestionsByQuizId(@RequestParam("quizId") Long quizId) {
        List<QitQuestion> qitQuestionSet = questionService.findQuestionsByQuizId(quizId);
        List<QuestionDTO> questionDTOs = new ArrayList<QuestionDTO>();
        for (QitQuestion question : qitQuestionSet) {
            questionDTOs.add(modelMapper.map(question, QuestionDTO.class));
        }
        return questionDTOs;
    }

    @RequestMapping(path = "", method = RequestMethod.POST)
    public QuestionDTO saveQuestion(@RequestBody QuestionDTO questionDTO) {
        questionService.saveQuestion(modelMapper.map(questionDTO, QitQuestion.class));
        return questionDTO;
    }

    @Transactional
    @Cascade(CascadeType.ALL)
    @RequestMapping(path = "/{questionId}", method = RequestMethod.DELETE)
    public void removeQuestionById(@PathVariable("questionId") Long questionId) {
        questionService.removeQuestionById(questionId);
    }

}




















