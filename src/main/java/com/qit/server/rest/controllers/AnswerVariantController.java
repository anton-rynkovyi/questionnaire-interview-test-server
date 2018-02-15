package com.qit.server.rest.controllers;

import com.qit.server.models.AnswerVariant;
import com.qit.server.rest.dto.AnswerVariantDTO;
import com.qit.server.service.answer.variant.AnswerVariantService;
import com.qit.server.service.question.QuestionService;
import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/api/answers-variants")
public class AnswerVariantController {

    final static Logger LOGGER = Logger.getLogger(AnswerVariantController.class);

    @Autowired
    private AnswerVariantService answerVariantService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping(path = "/{questionId}", method = RequestMethod.GET)
    public List<AnswerVariantDTO> findAnswerVariantsByQuestionId(@PathVariable("questionId") Long questionId) {
        LOGGER.info("CrudAnswerVariantController.findAnswerVariantsByQuestionId execute");

        List<AnswerVariant> answerVariants = answerVariantService.findAnswerVariantsByQuestionId(questionId);
        List<AnswerVariantDTO> answerVariantDTOs = new ArrayList<>();
        for (AnswerVariant answerVariant : answerVariants) {
            answerVariantDTOs.add(modelMapper.map(answerVariant, AnswerVariantDTO.class));
        }
        return answerVariantDTOs;
    }

    @RequestMapping(path = "/ans-var/{answerVariantId}", method = RequestMethod.GET)
    public AnswerVariantDTO findAnswerVariant(@PathVariable("answerVariantId") Long answerVariantId) {
        LOGGER.info("CrudAnswerVariantController.findAnswerVariant execute");

        AnswerVariant answerVariant = answerVariantService.findAnswerVariant(answerVariantId);
        AnswerVariantDTO answerVariantDTO = modelMapper.map(answerVariant, AnswerVariantDTO.class);
        return answerVariantDTO;
    }

    @RequestMapping(path = "", method = RequestMethod.POST)
    public AnswerVariantDTO saveAnswerVariant(@RequestBody AnswerVariantDTO answerVariantDTO) {
        LOGGER.info("CrudAnswerVariantController.saveAnswerVariant execute");

        AnswerVariant answerVariant = modelMapper.map(answerVariantDTO, AnswerVariant.class);
        //todo make true mapping without questionService#findQuestionById()
        answerVariant.setQitQuestion(questionService.findQuestionById(answerVariantDTO.getQuestionId()));
        answerVariantService.saveAnswerVariant(answerVariant);
        return answerVariantDTO;
    }

    @RequestMapping(path = "/{answerVariantId}", method = RequestMethod.DELETE)
    public void removeAnswerVariantById(@PathVariable("answerVariantId") Long answerVariantId) {
        LOGGER.info("CrudAnswerVariantController.removeAnswerVariantById execute");
        answerVariantService.removeAnswerVariantById(answerVariantId);
    }
}
