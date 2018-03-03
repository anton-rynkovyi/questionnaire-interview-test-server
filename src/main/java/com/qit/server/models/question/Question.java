package com.qit.server.models.question;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.qit.server.models.answer.Variant;
import com.qit.server.models.quiz.Quiz;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "questions")
@Data
public class Question {

	@Id
	@SequenceGenerator(name = "questions_seq", sequenceName = "questions_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "questions_seq")
	private Long id;

	@Column(name = "necessary", columnDefinition = "BOOLEAN DEFAULT TRUE")
	private Boolean isNecessary = false;

	@Column(name = "text")
	private String text;

	@Enumerated(value = EnumType.STRING)
	@Column(name = "question_type")
	private QuestionType questionType;

	@ManyToOne
	@JoinColumn(name = "quiz_id")
	private Quiz quiz;

	@JsonIgnore
	@OneToMany(mappedBy = "question", fetch = FetchType.LAZY)
	private Set<Variant> variants;
}
