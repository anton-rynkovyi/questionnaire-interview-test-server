package com.qit.server.dto;

import com.qit.server.models.answer.Variant;
import com.qit.server.models.question.QuestionType;
import lombok.Data;

import java.util.Set;

@Data
public class QuestionDto {

	private Long id;
	private Boolean isNecessary;
	private String text;
	private QuestionType questionType;
	private Long quizId;
	private Set<VariantDto> variants;

}
