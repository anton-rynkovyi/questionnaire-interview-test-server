package com.qit.server.models;

import java.math.BigInteger;

public class TestDetails {

    private BigInteger testId;
    private BigInteger quizId;

    public BigInteger getTestId() {
        return testId;
    }

    public void setTestId(BigInteger testId) {
        this.testId = testId;
    }

    public BigInteger getQuizId() {
        return quizId;
    }

    public void setQuizId(BigInteger quizId) {
        this.quizId = quizId;
    }

    @Override
    public String toString() {
        return "TestDetails{" +
                "testId=" + testId +
                ", quizId=" + quizId +
                '}';
    }
}
