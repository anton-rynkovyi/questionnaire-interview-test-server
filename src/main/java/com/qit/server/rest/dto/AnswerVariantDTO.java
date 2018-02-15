package com.qit.server.rest.dto;

public class AnswerVariantDTO {

    private Long questionId;
    private Long answerVariantId;
    private String answer;

    public AnswerVariantDTO() {
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Long getAnswerVariantId() {
        return answerVariantId;
    }

    public void setAnswerVariantId(Long answerVariantId) {
        this.answerVariantId = answerVariantId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
