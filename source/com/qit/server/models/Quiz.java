package com.qit.server.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "quizzes")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Quiz {

    @Id
    @SequenceGenerator(name = "quizzes_seq", sequenceName = "quizzes_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "quizzes_seq")
    @Column(name = "quiz_id")
    private Long quizId;

    @Column(name = "title")
    private String title;

    @Column(name = "topic")
    private String topic;

    @ManyToOne
    @JoinColumn(name = "username")
    private User owner;

    @ManyToMany(targetEntity = User.class, mappedBy = "quizzes")
    private Set<User> participants;


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

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Set<User> getParticipants() {
        return participants;
    }

    public void setParticipants(Set<User> participants) {
        this.participants = participants;
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
