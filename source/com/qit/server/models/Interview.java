package com.qit.server.models;

import javax.persistence.*;

@Entity
@Table(name = "interviews")
public class Interview extends Quiz {

    @OneToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    @Column(name = "members_limit")
    private Integer membersLimit;

    @Column(name = "password")
    private String password;

    @Column(name = "res_visibility")
    private Boolean resultVisibility;

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
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

    @Override
    public String toString() {
        return "Interview{" +
                "quiz=" + quiz +
                ", membersLimit=" + membersLimit +
                ", password='" + password + '\'' +
                ", resultVisibility=" + resultVisibility +
                '}';
    }
}

