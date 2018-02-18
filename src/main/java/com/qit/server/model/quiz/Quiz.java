package com.qit.server.model.quiz;

import com.qit.server.model.user.User;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "quizzes")
@Data
public class Quiz {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	@JoinColumn(name = "author_id")
	private User author;

	@OneToMany(mappedBy = "quiz")
	private Set<Result> results;

}
