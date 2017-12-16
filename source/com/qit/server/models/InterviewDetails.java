package com.qit.server.models;

import java.math.BigInteger;

public class InterviewDetails {

    private BigInteger interviewId;
    private BigInteger quizId;
    private Integer membersLimit;
    private String password;
    private Boolean resultVisibility;

    public BigInteger getInterviewId() {
        return interviewId;
    }

    public void setInterviewId(BigInteger interviewId) {
        this.interviewId = interviewId;
    }

    public BigInteger getQuizId() {
        return quizId;
    }

    public void setQuizId(BigInteger quizId) {
        this.quizId = quizId;
    }

    public Integer getMembersLimit() {
        return membersLimit;
    }

    public void setMembersLimit(Integer membersLimit) {
        this.membersLimit = membersLimit;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isResultVisibility() {
        return resultVisibility;
    }

    public void setResultVisibility(boolean resultVisibility) {
        this.resultVisibility = resultVisibility;
    }

    @Override
    public String toString() {
        return "InterviewDetails{" +
                "interviewId=" + interviewId +
                ", quizId=" + quizId +
                ", membersLimit=" + membersLimit +
                ", password='" + password + '\'' +
                ", resultVisibility=" + resultVisibility +
                '}';
    }
}
