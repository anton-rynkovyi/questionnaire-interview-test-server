package com.qit.server.models;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "answers_variants")
public class AnswerVariant {

    @Id
    @SequenceGenerator(name = "answers_variants_seq", sequenceName = "answers_variants_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "answers_variants_seq")
    @Column(name = "answer_variant_id")
    private Long answerVariantId;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private QitQuestion qitQuestion;

    @Column(name = "answer")
    private String answer;

    public Long getAnswerVariantId() {
        return answerVariantId;
    }

    public void setAnswerVariantId(Long answerVariantId) {
        this.answerVariantId = answerVariantId;
    }

    public QitQuestion getQitQuestion() {
        return qitQuestion;
    }

    public void setQitQuestion(QitQuestion qitQuestion) {
        this.qitQuestion = qitQuestion;
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
                ", answer='" + answer + '\'' +
                '}';
    }
}
