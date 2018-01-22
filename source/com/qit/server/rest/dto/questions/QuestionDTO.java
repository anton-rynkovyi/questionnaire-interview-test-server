package com.qit.server.rest.dto.questions;

import com.qit.server.models.AnswerVariant;
import com.qit.server.models.QitAnswer;
import com.qit.server.rest.dto.answer.AnswerDTO;
import com.qit.server.rest.dto.answer.variant.AnswerVariantDTO;

import java.util.Set;

public class QuestionDTO {

    private Long quizId;
    private Long questionId;
    private String summary;
    private Integer sequence;
    private Set<AnswerDTO> qitAnswers;
    private Set<AnswerVariantDTO> answerVariants;

    public QuestionDTO() {
    }


    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Set<AnswerDTO> getQitAnswers() {
        return qitAnswers;
    }

    public void setQitAnswers(Set<AnswerDTO> qitAnswers) {
        this.qitAnswers = qitAnswers;
    }

    public Set<AnswerVariantDTO> getAnswerVariants() {
        return answerVariants;
    }

    public void setAnswerVariants(Set<AnswerVariantDTO> answerVariants) {
        this.answerVariants = answerVariants;
    }

    public Long getQuizId() {
        return quizId;
    }

    public void setQuizId(Long quizId) {
        this.quizId = quizId;
    }
}
