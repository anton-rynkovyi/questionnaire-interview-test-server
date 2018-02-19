package com.qit.server.model.question;

import com.qit.server.model.answer.Variant;
import com.qit.server.model.quiz.Quiz;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "questions")
@Data
public class Question {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "necessary")
	private boolean isNecessary;

	@Column(name = "text")
	private String text;

	@Enumerated(value = EnumType.STRING)
	@Column(name = "question_type")
	private QuestionType questionType;

	@ManyToOne
	@JoinColumn(name = "quiz_id")
	private Quiz quiz;

	@OneToMany(mappedBy = "question", fetch = FetchType.LAZY)
	private Set<Variant> variants;
}
