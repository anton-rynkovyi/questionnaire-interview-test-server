package tests.controllers;

import com.qit.server.controller.QuestionController;
import com.qit.server.dto.QitResponse;
import com.qit.server.model.question.Question;
import com.qit.server.model.question.QuestionType;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import tests.AbstractTest;

import java.util.List;

public class QuestionControllerTest extends AbstractTest {

	@Autowired
	private QuestionController questionController;

	@Test
	public void getAllQuestions() {
		newQuestion();
		List<Question> questions = questionController.getAllQuestions();
		Assert.assertNotNull(questions);
	}

	@Test
	public void getQuestion() {
		ResponseEntity<QitResponse> responseEntity = newQuestion();
		Question question = questionController.getQuestion(responseEntity.getBody().getId());
		Assert.assertNotNull(question);
	}

	@Test
	public void saveQuestion() {
		ResponseEntity<QitResponse> responseEntity = newQuestion();
		Assert.assertTrue(responseEntity.getBody().isSuccessfully());
	}

	@Test
	public void deleteQuestion() {
		ResponseEntity<QitResponse> responseEntity = questionController.deleteQuestion(newQuestion().getBody().getId());
		Assert.assertTrue(responseEntity.getBody().isSuccessfully());
	}

	private ResponseEntity<QitResponse> newQuestion() {
		Question question = new Question();
		question.setQuestionType(QuestionType.CHECKBOX);
		question.setNecessary(true);
		question.setText("test text");
		return questionController.saveQuestion(question);
	}

}
