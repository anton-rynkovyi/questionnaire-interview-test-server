package com.qit.server.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class SimpleUser {

    @Id
    @Column(name = "username", nullable = false, length = 100, unique = true)
    private String username;

    @Column(name = "password", nullable = false, length = 100)
    private String password;

    @Column(name = "enabled")
    private Boolean enabled;

    @OneToMany(mappedBy = "user", targetEntity = UserRole.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<UserRole> userRoles;

    @OneToMany(targetEntity = Quiz.class, mappedBy = "owner")
    private Set<Quiz> ownedQuizzes;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "quizzes_users",
            joinColumns = @JoinColumn(name = "username"),
            inverseJoinColumns = @JoinColumn(name = "quiz_id")
    )
    private Set<Quiz> quizzes;


    public SimpleUser() {
        this.enabled = true;
    }

    public SimpleUser(String username, String password) {
        this();
        this.username = username;
        this.password = password;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    public Set<Quiz> getOwnedQuizzes() {
        return ownedQuizzes;
    }

    public void setOwnedQuizzes(Set<Quiz> ownedQuizzes) {
        this.ownedQuizzes = ownedQuizzes;
    }

    public Set<Quiz> getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(Set<Quiz> quizzes) {
        this.quizzes = quizzes;
    }

    @Deprecated
    public void addUserRoles(Set<UserRole> userRoles) {
        setUserRoles(userRoles);
        for (UserRole ur : userRoles) {
            ur.setUser(this);
        }
    }

    @Override
    public String toString() {
        return "SimpleUser{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                ", userRoles=" + userRoles +
                ", ownedQuizzes=" + ownedQuizzes +
                ", quizzes=" + quizzes +
                '}';
    }
}
