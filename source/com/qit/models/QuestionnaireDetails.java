package com.qit.models;

import java.math.BigInteger;
import java.util.Date;

public class QuestionnaireDetails {

    private BigInteger questionnaireId;
    private BigInteger quizId;
    private Date startDate;
    private Date endDate;
    private Integer answerLimit;
    private String password;
    private Boolean vote;
    private Boolean anonymity;
    private Boolean resultVisibility;

    public BigInteger getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(BigInteger questionnaireId) {
        this.questionnaireId = questionnaireId;
    }

    public BigInteger getQuizId() {
        return quizId;
    }

    public void setQuizId(BigInteger quizId) {
        this.quizId = quizId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
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

    public boolean isVote() {
        return vote;
    }

    public void setVote(boolean vote) {
        this.vote = vote;
    }

    public boolean isAnonymity() {
        return anonymity;
    }

    public void setAnonymity(boolean anonymity) {
        this.anonymity = anonymity;
    }

    public boolean isResultVisibility() {
        return resultVisibility;
    }

    public void setResultVisibility(boolean resultVisibility) {
        this.resultVisibility = resultVisibility;
    }

    @Override
    public String toString() {
        return "QuestionnaireDetails{" +
                "questionnaireId=" + questionnaireId +
                ", quizId=" + quizId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", answerLimit=" + answerLimit +
                ", password='" + password + '\'' +
                ", vote=" + vote +
                ", anonymity=" + anonymity +
                ", resultVisibility=" + resultVisibility +
                '}';
    }
}
