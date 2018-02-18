package com.qit.server.model.user;

import com.qit.server.model.quiz.Quiz;
import com.qit.server.model.quiz.Result;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
public class User {

	@Id
	@GeneratedValue
	private Long id;

	@Enumerated(value = EnumType.STRING)
	@Column(name = "gender")
	private Gender gender;

	@OneToMany(mappedBy = "author")
	private Set<Quiz> quizzes;

	@OneToMany(mappedBy = "author")
	private Set<Result> results;

}
