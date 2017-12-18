package com.qit.server.models;

import javax.persistence.*;

@Entity
@Table(name = "interview_details")
public class InterviewDetails {

    @Id
    @SequenceGenerator(name = "interview_details_seq", sequenceName = "interview_details_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "interview_details_seq")
    @Column(name = "interview_id")
    private Long interviewId;

    @OneToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    @Column(name = "members_limit")
    private Integer membersLimit;

    @Column(name = "password")
    private String password;

    @Column(name = "res_visibility")
    private Boolean resultVisibility;

    public Long getInterviewId() {
        return interviewId;
    }

    public void setInterviewId(Long interviewId) {
        this.interviewId = interviewId;
    }

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
                ", membersLimit=" + membersLimit +
                ", password='" + password + '\'' +
                ", resultVisibility=" + resultVisibility +
                '}';
    }
}
