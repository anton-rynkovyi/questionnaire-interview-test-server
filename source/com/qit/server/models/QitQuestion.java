package com.qit.server.models;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Set;

@Entity
@Table(name = "questions")
public class QitQuestion {

    @Id
    @SequenceGenerator(name = "questions_seq", sequenceName = "questions_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "questions_seq")
    @Column(name = "question_id")
    private Long questionId;

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    @Column(name = "summary")
    private String summary;

    @Column(name = "sequence")
    private Integer sequence;

    @OneToMany(mappedBy = "qitQuestion", targetEntity = QitAnswer.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<QitAnswer> qitAnswers;

    @OneToMany(mappedBy = "qitQuestion", targetEntity = AnswerVariant.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<AnswerVariant> answerVariants;

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Set<QitAnswer> getQitAnswers() {
        return qitAnswers;
    }

    public void setQitAnswers(Set<QitAnswer> qitAnswers) {
        this.qitAnswers = qitAnswers;
    }

    public Set<AnswerVariant> getAnswerVariants() {
        return answerVariants;
    }

    public void setAnswerVariants(Set<AnswerVariant> answerVariants) {
        this.answerVariants = answerVariants;
    }

    @Override
    public String toString() {
        return "QitQuestion{" +
                "questionId=" + questionId +
                ", summary='" + summary + '\'' +
                ", sequence=" + sequence +
                '}';
    }
}
