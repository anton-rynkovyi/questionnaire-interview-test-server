package com.qit.server.rest.dto;

import java.sql.Timestamp;
import java.util.Set;

public class QuestionnaireDTO extends QuizDTO {

    private Timestamp startDate;
    private Timestamp endDate;
    private Integer answerLimit;
    private String password;
    private Boolean vote;
    private Boolean anonymity;
    private Boolean resultVisibility;
    private Set<QuestionDTO> questions;


    public QuestionnaireDTO() {
    }


    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    public Integer getAnswerLimit() {
        return answerLimit;
    }

    public void setAnswerLimit(Integer answerLimit) {
        this.answerLimit = answerLimit;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getVote() {
        return vote;
    }

    public void setVote(Boolean vote) {
        this.vote = vote;
    }

    public Boolean getAnonymity() {
        return anonymity;
    }

    public void setAnonymity(Boolean anonymity) {
        this.anonymity = anonymity;
    }

    public Boolean getResultVisibility() {
        return resultVisibility;
    }

    public void setResultVisibility(Boolean resultVisibility) {
        this.resultVisibility = resultVisibility;
    }

    public Set<QuestionDTO> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<QuestionDTO> questions) {
        this.questions = questions;
    }
}
