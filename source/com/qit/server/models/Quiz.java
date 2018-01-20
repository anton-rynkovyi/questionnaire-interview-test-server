package com.qit.server.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "quizzes")
@Inheritance(strategy = InheritanceType.JOINED)
public class Quiz {

    @Id
    @SequenceGenerator(name = "quizzes_seq", sequenceName = "quizzes_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "quizzes_seq")
    @Column(name = "quiz_id")
    private Long quizId;

    @Column(name = "title")
    private String title;

    @Column(name = "topic")
    private String topic;

    @ManyToOne
    @JoinColumn(name = "username")
    private SimpleUser owner;

    @ManyToMany(targetEntity = SimpleUser.class, mappedBy = "quizzes")
    private Set<SimpleUser> participants;

    @OneToMany(targetEntity = QitQuestion.class, mappedBy = "quiz",  fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<QitQuestion> questions;

    public Long getQuizId() {
        return quizId;
    }

    public void setQuizId(Long quizId) {
        this.quizId = quizId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public SimpleUser getOwner() {
        return owner;
    }

    public void setOwner(SimpleUser owner) {
        this.owner = owner;
    }

    public Set<SimpleUser> getParticipants() {
        return participants;
    }

    public void setParticipants(Set<SimpleUser> participants) {
        this.participants = participants;
    }

    public Set<QitQuestion> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<QitQuestion> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "quizId=" + quizId +
                ", title='" + title + '\'' +
                ", topic='" + topic + '\'' +
                '}';
    }
}
