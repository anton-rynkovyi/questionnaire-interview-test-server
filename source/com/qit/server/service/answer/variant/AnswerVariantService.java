package com.qit.server.service.answer.variant;

import com.qit.server.models.AnswerVariant;
import com.qit.server.models.QitQuestion;

import java.util.List;

public interface AnswerVariantService {

    List<AnswerVariant> findAnswerVariantsByQuestion(QitQuestion question);
    List<AnswerVariant> findAnswerVariantsByQuestionId(Long questionId);
    AnswerVariant findAnswerVariant(Long answerVariantId);
    AnswerVariant saveAnswerVariant(AnswerVariant answerVariant);
    void removeAnswerVariantById(Long answerVariantId);
    List<AnswerVariant> findAllAnswerVariants();
}
