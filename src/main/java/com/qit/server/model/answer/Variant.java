package com.qit.server.model.answer;

import com.qit.server.model.question.Question;
import lombok.Data;

import javax.persistence.*;

/**
 * Created by Arizel on 18.02.2018.
 */
@Entity
@Data
public class Variant {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	@JoinColumn(name = "question_id")
	private Question question;
}
