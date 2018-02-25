package com.qit.server.model.user;

import com.qit.server.model.quiz.Quiz;
import com.qit.server.model.quiz.Result;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
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

	@Enumerated(value = EnumType.STRING)
	@Column(name = "gender")
	private Gender gender;


	/**Deleted to work without cycling*/
	/*@OneToMany(mappedBy = "author")
	private Set<Quiz> quizzes;*/

	@OneToMany(mappedBy = "author")
	private Set<Result> results;

}
