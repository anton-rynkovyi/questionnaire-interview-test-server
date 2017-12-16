package com.qit.server.models;

import java.math.BigInteger;

public class Quiz {

    private BigInteger quizId;
    private String username;
    private String title;
    private String topic;

    public BigInteger getQuizId() {
        return quizId;
    }

    public void setQuizId(BigInteger quizId) {
        this.quizId = quizId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "quizId=" + quizId +
                ", username='" + username + '\'' +
                ", title='" + title + '\'' +
                ", topic='" + topic + '\'' +
                '}';
    }
}
