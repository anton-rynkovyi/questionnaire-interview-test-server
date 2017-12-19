package com.qit.server.models;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "tests")
public class Test extends Quiz{

    @OneToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    @Override
    public String toString() {
        return "Test{" +
                "quiz=" + quiz +
                '}';
    }
}
