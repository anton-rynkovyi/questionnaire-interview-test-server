package com.qit.server.models.user;

public enum Gender {
	MALE("MALE"),
	FEMALE("FEMALE");

	private String gender;

	Gender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return gender;
	}
}
