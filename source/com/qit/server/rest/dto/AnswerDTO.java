package com.qit.server.rest.dto;

public class AnswerDTO {

    private Long questionId;
    private Long answerId;
    private String respondentUsername;
    private String answer;

    public AnswerDTO() {
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Long answerId) {
        this.answerId = answerId;
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

}
