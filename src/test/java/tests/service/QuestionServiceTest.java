package tests.service;

import com.qit.server.dto.QitResponse;
import com.qit.server.model.question.Question;
import com.qit.server.model.question.QuestionType;
import com.qit.server.service.question.QuestionService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tests.AbstractTest;

public class QuestionServiceTest extends AbstractTest {

	@Autowired
	private QuestionService questionService;

	@Test
	public void createQuestion() {
		Question question = newQuestion();
		QitResponse qitResponse = questionService.saveQuestion(question);
		Assert.assertTrue(qitResponse.isSuccessfully());
		qitResponse = questionService.saveQuestion(null);
		Assert.assertFalse(qitResponse.isSuccessfully());
	}

	@Test
	public void updateQuestion() {
		Question question = newQuestion();
		QitResponse qitResponse = questionService.saveQuestion(question);
		Assert.assertTrue(qitResponse.isSuccessfully());
		question = questionService.getQuestion(qitResponse.getId());
		question.setQuestionType(QuestionType.CHECKBOX);
		qitResponse = questionService.saveQuestion(question);
		question = questionService.getQuestion(qitResponse.getId());
		Assert.assertTrue(QuestionType.CHECKBOX == question.getQuestionType());
	}

	@Test
	public void deleteQuestion() {
		Question question = newQuestion();
		QitResponse qitResponse = questionService.saveQuestion(question);
		Assert.assertTrue(qitResponse.isSuccessfully());
		question = questionService.getQuestion(qitResponse.getId());
		qitResponse = questionService.deleteQuestion(question);
		Assert.assertTrue(qitResponse.isSuccessfully());
		qitResponse = questionService.deleteQuestion(null);
		Assert.assertFalse(qitResponse.isSuccessfully());
	}

	@Test
	public void deleteQuestionById() {
		Question question = newQuestion();
		QitResponse qitResponse = questionService.saveQuestion(question);
		Assert.assertTrue(qitResponse.isSuccessfully());
		qitResponse = questionService.deleteQuestionById(qitResponse.getId());
		Assert.assertTrue(qitResponse.isSuccessfully());
		qitResponse = questionService.deleteQuestionById(null);
		Assert.assertFalse(qitResponse.isSuccessfully());
	}

	private Question newQuestion() {
		Question question = new Question();
		question.setNecessary(true);
		question.setQuestionType(QuestionType.ONLY_ONE);

		return question;
	}
}
