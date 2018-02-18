package com.qit.server.model.answer;

import com.qit.server.model.quiz.Result;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Arizel on 18.02.2018.
 */
@Entity
@Data
public class Answer {

	@Id
	@GeneratedValue
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