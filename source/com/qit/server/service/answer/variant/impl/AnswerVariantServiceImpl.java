package com.qit.server.service.answer.variant.impl;

import com.qit.server.models.AnswerVariant;
import com.qit.server.models.QitQuestion;
import com.qit.server.repositories.AnswerVariantRepository;
import com.qit.server.service.answer.variant.AnswerVariantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerVariantServiceImpl implements AnswerVariantService {

    @Autowired
    private AnswerVariantRepository answerVariantRepository;

    @Override
    public List<AnswerVariant> findAnswerVariantsByQuestion(QitQuestion question) {
        return answerVariantRepository.findAnswerVariantsByQitQuestion(question);
    }

    @Override
    public List<AnswerVariant> findAnswerVariantsByQuestionId(Long questionId) {
        return answerVariantRepository.findAnswerVariantsByQitQuestionQuestionId(questionId);
    }

    @Override
    public AnswerVariant findAnswerVariant(Long answerVariantId) {
        return answerVariantRepository.findOne(answerVariantId);
    }

    @Override
    public AnswerVariant saveAnswerVariant(AnswerVariant answerVariant) {
        return answerVariantRepository.save(answerVariant);
    }

    @Override
    public void removeAnswerVariantById(Long answerVariantId) {
        answerVariantRepository.removeById(answerVariantId);
    }

    @Override
    public List<AnswerVariant> findAllAnswerVariants() {
        return answerVariantRepository.findAll();
    }
}
