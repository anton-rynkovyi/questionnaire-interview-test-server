package com.qit.server.models.answer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.qit.server.models.question.Question;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "variants")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Variant {

	@Id
	@SequenceGenerator(name = "answers_variants_seq", sequenceName = "answers_variants_seq",  allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "answers_variants_seq")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "question_id")
	private Question question;

	@Column(name = "text")
	private String text;

}
