package com.qit.server.model.quiz;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "questionnaires")
public class Questionnaire extends Quiz {

	@Column(name = "anonymity")
	private Boolean anonymity;

	@Column(name = "answer_limit")
	private Integer answerLimit;

}
