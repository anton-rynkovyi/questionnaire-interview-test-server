package com.qit.server.models;

import java.math.BigInteger;

public class QitAnswer {

    private BigInteger answerId;
    private BigInteger questionId;
    private String respondentUsername;
    private String answer;

    public BigInteger getAnswerId() {
        return answerId;
    }

    public void setAnswerId(BigInteger answerId) {
        this.answerId = answerId;
    }

    public BigInteger getQuestionId() {
        return questionId;
    }

    public void setQuestionId(BigInteger questionId) {
        this.questionId = questionId;
    }

    public String getRespondentUsername() {
        return respondentUsername;
    }

    public void setRespondentUsername(String respondentUsername) {
        this.respondentUsername = respondentUsername;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "QitAnswer{" +
                "answerId=" + answerId +
                ", questionId=" + questionId +
                ", respondentUsername='" + respondentUsername + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
