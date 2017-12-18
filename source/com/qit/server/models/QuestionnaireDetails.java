package com.qit.server.models;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name = "questionnaire_details")
public class QuestionnaireDetails {

    @Id
    @SequenceGenerator(name = "questionnaire_details_seq", sequenceName = "questionnaire_details_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "questionnaire_details_seq")
    @Column(name = "quest_id")
    private Long questionnaireId;

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

    @OneToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    public Long getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(Long questionnaireId) {
        this.questionnaireId = questionnaireId;
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

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    @Override
    public String toString() {
        return "QuestionnaireDetails{" +
                "questionnaireId=" + questionnaireId +
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
