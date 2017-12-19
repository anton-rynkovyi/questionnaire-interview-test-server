package com.qit.server.models;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name = "questionnaires")
public class Questionnaire extends Quiz {

    @Column(name = "start_date")
    private Timestamp startDate;

    @Column(name = "end_date")
    private Timestamp endDate;

    @Column(name = "answers_limit")
    private Integer answerLimit;

    @Column(name = "password")
    private String password;

    @Column(name = "vote")
    private Boolean vote;

    @Column(name = "anonymity")
    private Boolean anonymity;

    @Column(name = "res_visibility")
    private Boolean resultVisibility;

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

    @Override
    public String toString() {
        return "Questionnaire{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                ", answerLimit=" + answerLimit +
                ", password='" + password + '\'' +
                ", vote=" + vote +
                ", anonymity=" + anonymity +
                ", resultVisibility=" + resultVisibility +
                '}';
    }
}
