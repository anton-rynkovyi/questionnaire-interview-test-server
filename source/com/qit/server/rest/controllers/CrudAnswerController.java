package com.qit.server.rest.controllers;

import com.qit.server.models.QitAnswer;
import com.qit.server.rest.dto.AnswerDTO;
import com.qit.server.service.answer.AnswerService;
import com.qit.server.service.question.QuestionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/api/answers")
public class CrudAnswerController {

    @Autowired
    private AnswerService answerService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping(path = "/{questionId}", method = RequestMethod.GET)
    public List<AnswerDTO> findAnswerByQuestionId(@PathVariable("questionId") Long questionId) {
        List<QitAnswer> answers = answerService.findAnswersByQuestionId(questionId);
        List<AnswerDTO> answerDTOs = new ArrayList<>();
        for (QitAnswer answer : answers) {
            answerDTOs.add(modelMapper.map(answer, AnswerDTO.class));
        }
        return answerDTOs;
    }

    @RequestMapping(path = "/ans/{answerId}", method = RequestMethod.GET)
    public AnswerDTO findAnswer(@PathVariable("answerId") Long answerId) {
        QitAnswer answer = answerService.findAnswer(answerId);
        AnswerDTO answerDTO = modelMapper.map(answer, AnswerDTO.class);
        return answerDTO;
    }

    @RequestMapping(path = "", method = RequestMethod.POST)
    public AnswerDTO saveAnswer(@RequestBody AnswerDTO answerDTO) {
        QitAnswer answer = modelMapper.map(answerDTO, QitAnswer.class);
        //todo make true mapping without questionService#findQuestionById()
        answer.setQitQuestion(questionService.findQuestionById(answerDTO.getQuestionId()));
        answerService.saveAnswer(answer);
        return answerDTO;
    }

    @Transactional
    @RequestMapping(path = "/{answerId}", method = RequestMethod.DELETE)
    public void removeAnswerById(@PathVariable("answerId") Long answerId) {
        answerService.removeAnswerById(answerId);
    }
}
