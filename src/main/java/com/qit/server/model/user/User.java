package com.qit.server.model.user;

import com.qit.server.model.quiz.Quiz;
import com.qit.server.model.quiz.Result;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Arizel on 18.02.2018.
 */
@Entity
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
