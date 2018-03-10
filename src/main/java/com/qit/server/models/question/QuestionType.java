package com.qit.server.models.question;

public enum QuestionType {
	CHECKBOX("CHECKBOX"),
	RADIO("RADIO"),
	DETAILED("DETAILED");

	private String questionType;

	QuestionType(String questionType) {
		this.questionType = questionType;
	}

	@Override
	public String toString() {
		return questionType;
	}
}
