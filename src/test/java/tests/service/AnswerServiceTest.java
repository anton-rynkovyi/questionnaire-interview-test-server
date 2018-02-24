package tests.service;

import com.qit.server.dto.QitResponse;
import com.qit.server.model.answer.Answer;
import com.qit.server.service.answer.AnswerService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tests.AbstractTest;

public class AnswerServiceTest extends AbstractTest {

	@Autowired
	private AnswerService answerService;

	@Test
	public void getAllAnswers() {
		answerService.getAllAnswers();
	}

	@Test
	public void getAnswer() {
		QitResponse qitResponse = newAnswer();
		Assert.assertTrue(qitResponse.isSuccessfully());
		Answer answer = answerService.getAnswer(qitResponse.getId());
		Assert.assertNotNull(answer);
		answer = answerService.getAnswer(null);
		Assert.assertNull(answer);
	}

	@Test
	public void saveAnswer() {
		QitResponse qitResponse = newAnswer();
		Assert.assertTrue(qitResponse.isSuccessfully());
		qitResponse = answerService.save(null);
		Assert.assertFalse(qitResponse.isSuccessfully());
	}

	@Test
	public void deleteAnswer() {
		QitResponse qitResponse = newAnswer();
		qitResponse = answerService.delete(answerService.getAnswer(qitResponse.getId()));
		Assert.assertNotNull(qitResponse);
		Assert.assertTrue(qitResponse.isSuccessfully());
		qitResponse = answerService.delete(null);
		Assert.assertFalse(qitResponse.isSuccessfully());
	}

	@Test
	public void deleteAnswerById() {
		QitResponse qitResponse = newAnswer();
		qitResponse = answerService.deleteById(qitResponse.getId());
		Assert.assertNotNull(qitResponse);
		Assert.assertTrue(qitResponse.isSuccessfully());
		qitResponse = answerService.delete(null);
		Assert.assertFalse(qitResponse.isSuccessfully());
	}

	private QitResponse newAnswer() {
		Answer answer = new Answer();
		return answerService.save(answer);
	}

}
