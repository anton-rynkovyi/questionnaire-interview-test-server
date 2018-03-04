package com.qit.server.dto;

import com.qit.server.models.answer.Variant;
import lombok.Data;

import java.util.Set;

@Data
public class QuestionDto {
	private Long id;
	private Boolean isNecessary;
	private String text;
	private String questionType;
	private Long quizId;
	private Set<Variant> variants;
}
