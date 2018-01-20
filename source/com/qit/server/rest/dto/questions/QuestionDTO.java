package com.qit.server.rest.dto.questions;

import com.qit.server.models.AnswerVariant;
import com.qit.server.models.QitAnswer;

import java.util.Set;

public class QuestionDTO {

    private Long quizId;
    private Long questionId;
    private String summary;
    private Integer sequence;
    private Set<QitAnswer> qitAnswers;
    private Set<AnswerVariant> answerVariants;

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

    public Set<QitAnswer> getQitAnswers() {
        return qitAnswers;
    }

    public void setQitAnswers(Set<QitAnswer> qitAnswers) {
        this.qitAnswers = qitAnswers;
    }

    public Set<AnswerVariant> getAnswerVariants() {
        return answerVariants;
    }

    public void setAnswerVariants(Set<AnswerVariant> answerVariants) {
        this.answerVariants = answerVariants;
    }

    public Long getQuizId() {
        return quizId;
    }

    public void setQuizId(Long quizId) {
        this.quizId = quizId;
    }
}
