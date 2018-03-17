package com.qit.server.models.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.qit.server.models.quiz.Quiz;
import com.qit.server.models.quiz.Result;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {

	@Id
	@Column(name = "login", unique = true, nullable = false, length = 50)
	private String login;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "enabled", columnDefinition = "BOOLEAN DEFAULT TRUE")
	private boolean isEnabled = true;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email")
	private String email;

	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "birthday")
	private Date birthday;

	@Column(name = "additional_info")
	private String additionalInfo;

//	@Enumerated(value = EnumType.STRING)
	@Column(name = "gender")
	private String gender;

	@JsonIgnore
	@OneToMany(mappedBy = "author")
	private Set<Quiz> quizzes;

	@JsonIgnore
	@OneToMany(mappedBy = "author")
	private Set<Result> results;


	public Gender getGender() {
		if (Gender.MALE.toString().equals(gender)) {
			return Gender.MALE;
		}
		if (Gender.FEMALE.toString().equals(gender)) {
			return Gender.FEMALE;
		}
		return null;
	}

	public void setGender(Gender gender) {
		this.gender = gender.toString();
	}
}
