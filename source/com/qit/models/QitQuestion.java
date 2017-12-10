package com.qit.models;

import org.hibernate.annotations.Table;

import javax.persistence.Entity;
import java.math.BigInteger;

public class QitQuestion {

    private BigInteger questionId;
    private BigInteger quizId;
    private String summary;
    private Integer sequence;


    public BigInteger getQuestionId() {
        return questionId;
    }

    public void setQuestionId(BigInteger questionId) {
        this.questionId = questionId;
    }

    public BigInteger getQuizId() {
        return quizId;
    }

    public void setQuizId(BigInteger quizId) {
        this.quizId = quizId;
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

    @Override
    public String toString() {
        return "QitQuestion{" +
                "questionId=" + questionId +
                ", quizId=" + quizId +
                ", summary='" + summary + '\'' +
                ", sequence=" + sequence +
                '}';
    }
}
