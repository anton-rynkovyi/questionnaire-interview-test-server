package tests.controllers;

import com.qit.server.controller.ResultController;
import com.qit.server.dto.QitResponse;
import com.qit.server.model.quiz.Result;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import tests.AbstractTest;

import java.util.List;

public class ResultControllerTest extends AbstractTest {

	@Autowired
	private ResultController resultController;

	@Test
	public void getAllResults() {
		ResponseEntity<QitResponse> responseEntity = newRusult();
		List<Result> results = resultController.getAllResults();
		Assert.assertNotNull(results);
		Assert.assertFalse(results.isEmpty());
	}

	@Test
	public void getResult() {
		ResponseEntity<QitResponse> responseEntity = newRusult();
		Assert.assertNotNull(resultController.getResult(responseEntity.getBody().getId()));
	}

	@Test
	public void saveResult() {
		ResponseEntity<QitResponse> responseEntity = newRusult();
		Assert.assertTrue(responseEntity.getBody().isSuccessfully());
	}

	@Test
	public void deleteResult() {
		ResponseEntity<QitResponse> responseEntity = newRusult();
		responseEntity = resultController.deleteResult(responseEntity.getBody().getId());
		Assert.assertTrue(responseEntity.getBody().isSuccessfully());
	}

	private ResponseEntity<QitResponse> newRusult() {
		return resultController.saveResult(new Result());
	}

}
