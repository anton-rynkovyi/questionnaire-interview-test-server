package com.qit.server.model.quiz;

import com.qit.server.model.answer.Answer;
import com.qit.server.model.user.User;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "results")
@Data
public class Result {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	@JoinColumn(name = "author_id")
	private User author;

	@ManyToOne
	@JoinColumn(name = "quiz_id")
	private Quiz quiz;

	@OneToMany(mappedBy = "result")
	private Set<Answer> answers;

}
