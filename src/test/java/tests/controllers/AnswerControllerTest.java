package tests.controllers;

import com.qit.server.controller.AnswerController;
import com.qit.server.dto.QitResponse;
import com.qit.server.model.answer.Answer;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import tests.AbstractTest;

import java.util.List;

public class AnswerControllerTest extends AbstractTest {

	@Autowired
	private AnswerController answerController;

	@Test
	public void getAnswers() {
		ResponseEntity<QitResponse> responseEntity = newAnswer();
		List<Answer> answers = answerController.getAnswers();
		Assert.assertNotNull(answers);
		Assert.assertFalse(answers.isEmpty());
	}

	@Test
	public void getAnswer() {
		ResponseEntity<QitResponse> responseEntity = newAnswer();
		Answer answer = answerController.getAnswerById(responseEntity.getBody().getId());
		Assert.assertNotNull(answer);
		answer = answerController.getAnswerById(null);
		Assert.assertNull(answer);
	}

	@Test
	public void saveAnswer() {
		ResponseEntity<QitResponse> responseEntity = newAnswer();
		Assert.assertTrue(responseEntity.getBody().isSuccessfully());
		Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		responseEntity = answerController.createAnswer(null, null);
		Assert.assertFalse(responseEntity.getBody().isSuccessfully());
	}

	@Test
	public void deleteAnswer() {
		ResponseEntity<QitResponse> responseEntity = newAnswer();
		responseEntity = answerController.deleteAnswer(responseEntity.getBody().getId(), null);
		Assert.assertTrue(responseEntity.getBody().isSuccessfully());
		Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
		responseEntity = answerController.deleteAnswer(null, null);
		Assert.assertFalse(responseEntity.getBody().isSuccessfully());
	}

	private ResponseEntity<QitResponse> newAnswer() {
		Answer answer = new Answer();
		return answerController.createAnswer(answer, null);
	}

}
