package com.qit.server.model.quiz;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "interviews")
public class Interview extends Quiz {

	@Column(name = "members_limit")
	private Integer memberLimit;

}
