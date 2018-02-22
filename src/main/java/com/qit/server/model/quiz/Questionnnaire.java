package com.qit.server.model.quiz;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "Questionnaires")
public class Questionnnaire extends Quiz {

	@Column(name = "summary")
	private String summary;

	@Column(name = "sequence")
	private Integer sequence;

	@Column(name = "anonymity")
	private Boolean anonymity;

	@Column(name = "answer_limit")
	private Integer answerLimit;

}
