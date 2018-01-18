package com.qit.server.rest.dto.quizzes.interview;

public class InterviewDTO {

    private Integer membersLimit;
    private String password;
    private Boolean resultVisibility;

    public InterviewDTO() {
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
