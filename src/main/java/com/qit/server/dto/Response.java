package com.qit.server.dto;

import lombok.Data;

@Data
public class Response {

	private Long id;
	private boolean isSuccessfully;
	private String errorMessage;

	public void successed() {
		isSuccessfully = true;
	}

	public void failed() {
		isSuccessfully = false;
	}

}
