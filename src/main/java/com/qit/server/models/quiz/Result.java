package com.qit.server.models.quiz;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.qit.server.models.answer.Answer;
import com.qit.server.models.user.User;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "results")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Result {

	@Id
	@SequenceGenerator(name = "results_seq", sequenceName = "results_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "results_seq")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "member_username")
	private User author;

	@ManyToOne
	@JoinColumn(name = "quiz_id")
	private Quiz quiz;

	@JsonIgnore
	@OneToMany(mappedBy = "result")
	private Set<Answer> answers;

}
