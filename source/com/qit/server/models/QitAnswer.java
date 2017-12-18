package com.qit.server.models;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "answers")
public class QitAnswer {

    @Id
    @SequenceGenerator(name = "answers_seq", sequenceName = "answers_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "answers_seq")
    @Column(name = "answer_id")
    private Long answerId;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private QitQuestion qitQuestion;

    @Column(name = "respondent_username")
    private String respondentUsername;

    @Column(name = "answer")
    private String answer;

    public Long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Long answerId) {
        this.answerId = answerId;
    }

    public QitQuestion getQitQuestion() {
        return qitQuestion;
    }

    public void setQitQuestion(QitQuestion qitQuestion) {
        this.qitQuestion = qitQuestion;
    }

    public String getRespondentUsername() {
        return respondentUsername;
    }

    public void setRespondentUsername(String respondentUsername) {
        this.respondentUsername = respondentUsername;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "QitAnswer{" +
                "answerId=" + answerId +
                ", respondentUsername='" + respondentUsername + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
