package com.qit.server.models;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "test_details")
public class TestDetails {

    @Id
    @SequenceGenerator(name = "test_details_seq", sequenceName = "test_details_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "test_details_seq")
    @Column(name = "test_id")
    private Long testId;

    @OneToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    public Long getTestId() {
        return testId;
    }

    public void setTestId(Long testId) {
        this.testId = testId;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    @Override
    public String toString() {
        return "TestDetails{" +
                "testId=" + testId +
                '}';
    }
}
