package com.qit.server.model.answer;

import com.qit.server.model.quiz.Result;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "answers")
@Data
public class Answer {

	@Id
	@SequenceGenerator(name = "answers_seq", sequenceName = "answers_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "answers_seq")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "result_id")
	private Result result;

	@ManyToMany
	@JoinTable(name = "answer_variant",
			joinColumns = @JoinColumn(name = "variant_id"),
			inverseJoinColumns = @JoinColumn(name = "answer_id"))
	private Set<Variant> variants;
}
