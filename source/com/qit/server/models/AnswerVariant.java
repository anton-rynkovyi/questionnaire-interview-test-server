package com.qit.server.models;

import javax.persistence.*;
import java.math.BigInteger;

//@Entity
//@Table(name = "answers_variants")
public class AnswerVariant {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "answer_variant_id")
    private BigInteger answerVariantId;

//    @Column(name = "question_id")
    private BigInteger questionId;

//    @Column(name = "answer")
    private String answer;

    public BigInteger getAnswerVariantId() {
        return answerVariantId;
    }

    public void setAnswerVariantId(BigInteger answerVariantId) {
        this.answerVariantId = answerVariantId;
    }

    public BigInteger getQuestionId() {
        return questionId;
    }

    public void setQuestionId(BigInteger questionId) {
        this.questionId = questionId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "AnswerVariant{" +
                "answerVariantId=" + answerVariantId +
                ", questionId=" + questionId +
                ", answer='" + answer + '\'' +
                '}';
    }
}
