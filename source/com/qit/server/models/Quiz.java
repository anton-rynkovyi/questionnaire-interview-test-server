package com.qit.server.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "quizzes")
public class Quiz {

    @Id
    @SequenceGenerator(name = "quizzes_seq", sequenceName = "quizzes_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "quizzes_seq")
    @Column(name = "quiz_id")
    private Long quizId;

    @Column(name = "username")
    private String username;

    @Column(name = "title")
    private String title;

    @Column(name = "topic")
    private String topic;

    @ManyToMany(mappedBy = "quizzes")
    private Set<User> users;

    @OneToOne(mappedBy = "quiz", targetEntity = QuestionnaireDetails.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private QuestionnaireDetails questionnaireDetails;

    @OneToOne(mappedBy = "quiz", targetEntity = InterviewDetails.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private InterviewDetails interviewDetails;

    @OneToOne(mappedBy = "quiz", targetEntity = TestDetails.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private TestDetails testDetails;

    @OneToMany(mappedBy = "quiz", targetEntity = QitQuestion.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<QitQuestion> qitQuestions;

    public Long getQuizId() {
        return quizId;
    }

    public void setQuizId(Long quizId) {
        this.quizId = quizId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    @Override
    public String toString() {
        return "Quiz{" +
                "quizId=" + quizId +
                ", username='" + username + '\'' +
                ", title='" + title + '\'' +
                ", topic='" + topic + '\'' +
                '}';
    }
}
