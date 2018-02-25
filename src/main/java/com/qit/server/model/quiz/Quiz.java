package com.qit.server.model.quiz;

import com.qit.server.model.user.User;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "quizzes")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Data
public abstract class Quiz {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "summary")
	private String summary;

	@Column(name = "description")
	private String description;

	@ManyToOne
	@JoinColumn(name = "author_id")
	private User author;

	@OneToMany(mappedBy = "quiz")
	private Set<Result> results;

}
