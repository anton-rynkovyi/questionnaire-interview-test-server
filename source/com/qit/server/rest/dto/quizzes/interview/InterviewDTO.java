package com.qit.server.rest.dto.quizzes.interview;

import com.qit.server.rest.dto.questions.QuestionDTO;
import com.qit.server.rest.dto.quizzes.quiz.QuizDTO;

import java.util.Set;

public class InterviewDTO extends QuizDTO {

    private Integer membersLimit;
    private String password;
    private Boolean resultVisibility;
    private Set<QuestionDTO> questions;

    public InterviewDTO() {
    }

    public Set<QuestionDTO> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<QuestionDTO> questions) {
        this.questions = questions;
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

    public Boolean getResultVisibility() {
        return resultVisibility;
    }

    public void setResultVisibility(Boolean resultVisibility) {
        this.resultVisibility = resultVisibility;
    }
}
