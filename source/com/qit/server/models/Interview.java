package com.qit.server.models;

import javax.persistence.*;

@Entity
@Table(name = "interview_details")
public class Interview extends Quiz {

    @Column(name = "members_limit")
    private Integer membersLimit;

    @Column(name = "password")
    private String password;

    @Column(name = "res_visibility")
    private Boolean resultVisibility;

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
                "membersLimit=" + membersLimit +
                ", password='" + password + '\'' +
                ", resultVisibility=" + resultVisibility +
                '}';
    }
}

