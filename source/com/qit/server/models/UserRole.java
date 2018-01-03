package com.qit.server.models;

import javax.persistence.*;

@Entity
@Table(name = "user_roles")
public class UserRole {

    @Id
    @SequenceGenerator(name = "user_role_seq", sequenceName = "user_role_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_role_seq")
    @Column(name = "user_role_id")
    private Long userRoleId;

    @ManyToOne
    @JoinColumn(name = "username")
    private SimpleUser user;

    @Column(name = "role")
    private String role;

    public UserRole() {
    }

    public UserRole(String role) {
        this.role = role;
    }

    public UserRole(SimpleUser user, String role) {
        this.role = role;
        this.user = user;
    }

    public Long getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Long userRoleId) {
        this.userRoleId = userRoleId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public SimpleUser getUser() {
        return user;
    }

    public void setUser(SimpleUser user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "userRoleId=" + userRoleId +
                ", role='" + role + '\'' +
                '}';
    }
}
