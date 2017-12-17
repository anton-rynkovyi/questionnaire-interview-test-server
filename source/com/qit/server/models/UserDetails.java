package com.qit.server.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "user_details")
public class UserDetails {

    @Id
    @SequenceGenerator(name = "user_details_seq", sequenceName = "user_details_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_details_seq")
    @Column(name = "user_details_id")
    private Long userDetailsId;

    @OneToOne
    @JoinColumn(name = "username")
    private User user;

    @Column(name = "first_name", length = 100)
    private String firstName;

    @Column(name = "last_name", length = 100)
    private String lastName;

    @Column(name = "email", length = 100, unique = true)
    private String email;

    @Column(name = "phone_number", length = 40, unique = true)
    private String phoneNumber;

    @Column(name = "gender")
    private Boolean gender;

    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "additional_info")
    private String additionalInfo;


    public Long getUserDetailsId() {
        return userDetailsId;
    }

    public void setUserDetailsId(Long userDetailsId) {
        this.userDetailsId = userDetailsId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }


}
