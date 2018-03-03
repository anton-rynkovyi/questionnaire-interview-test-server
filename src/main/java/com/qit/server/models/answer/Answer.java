package com.qit.server.models.answer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.qit.server.models.question.Question;
import com.qit.server.models.quiz.Result;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "answers")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Answer {

	@Id
	@SequenceGenerator(name = "answers_seq", sequenceName = "answers_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "answers_seq")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "result_id")
	private Result result;

	@ManyToOne
	@JoinColumn(name = "question_id")
	private Question question;

	@ManyToMany
	@JoinTable(name = "answers_variants",
			joinColumns = @JoinColumn(name = "answer_id"),
			inverseJoinColumns = @JoinColumn(name = "variant_id"))
	private Set<Variant> variants;
}
