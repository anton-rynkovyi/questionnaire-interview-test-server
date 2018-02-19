package com.qit.server.dto;

import lombok.Data;

@Data
public class QitResponse {

	private Long id;
	private boolean isSuccessfully;
	private String primaryKey;
	private String errorMessage;

	public void successed() {
		isSuccessfully = true;
	}

	public void failed() {
		isSuccessfully = false;
	}

}
