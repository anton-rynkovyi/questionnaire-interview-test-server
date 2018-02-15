package com.qit.server.rest.dto;


public class QuizDTO {

    private Long quizId;
    private String title;
    private String topic;
    private UserCredentialDTO owner;


    public QuizDTO() {
    }

    public Long getQuizId() {
        return quizId;
    }

    public void setQuizId(Long quizId) {
        this.quizId = quizId;
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

    public UserCredentialDTO getOwner() {
        return owner;
    }

    public void setOwner(UserCredentialDTO owner) {
        this.owner = owner;
    }
}
