package com.qit.server.models.quiz;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.qit.server.models.user.User;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;


@Entity
@Table(name = "quizzes")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Data
public abstract class Quiz {

	@Id
	@SequenceGenerator(name = "quizzes_seq", sequenceName = "quizzes_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "quizzes_seq")
	private Long id;

	@Column(name = "summary")
	private String summary;

	@Column(name = "description")
	private String description;

	@Column(name = "password")
	private String password;

	@ManyToOne
	@JoinColumn(name = "author_username")
	private User author;

	@JsonIgnore
	@OneToMany(mappedBy = "quiz")
	private Set<Result> results;

	@Column(name = "start_date")
	private Date startDate;


	@Column(name = "end_date")
	private Date endDate;
}
