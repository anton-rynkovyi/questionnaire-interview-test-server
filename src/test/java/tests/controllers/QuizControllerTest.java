package tests.controllers;

import com.qit.server.controller.QuizController;
import com.qit.server.dto.QitResponse;
import com.qit.server.model.quiz.Interview;
import com.qit.server.model.quiz.Questionnaire;
import com.qit.server.model.quiz.Quiz;
import com.qit.server.model.quiz.QuizTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import tests.AbstractTest;

public class QuizControllerTest extends AbstractTest {

	@Autowired
	private QuizController quizController;

	@Test
	public void getAllQuizzes() {
		ResponseEntity<QitResponse> responseEntity = newQuizTest();
		Assert.assertNotNull(quizController.getQuizzes());
	}

	@Test
	public void getQuiz() {
		ResponseEntity<QitResponse> responseEntity = newQuizTest();
		Assert.assertNotNull(quizController.getQuizById(responseEntity.getBody().getId()));
		responseEntity = newInterview();
		Assert.assertNotNull(quizController.getQuizById(responseEntity.getBody().getId()));
		responseEntity = newQuestionnaire();
		Assert.assertNotNull(quizController.getQuizById(responseEntity.getBody().getId()));
	}

	@Test
	public void saveQuiz() {
		Assert.assertTrue(newQuizTest().getBody().isSuccessfully());
		Assert.assertTrue(newQuestionnaire().getBody().isSuccessfully());
		Assert.assertTrue(newInterview().getBody().isSuccessfully());
	}

	@Test
	public void deleteQuiz() {
		ResponseEntity<QitResponse> responseEntity = newQuizTest();
		responseEntity = quizController.deleteQuiz(responseEntity.getBody().getId(), null);
		Assert.assertTrue(responseEntity.getBody().isSuccessfully());
		responseEntity = newInterview();
		responseEntity = quizController.deleteQuiz(responseEntity.getBody().getId(), null);
		Assert.assertTrue(responseEntity.getBody().isSuccessfully());
		responseEntity = newQuestionnaire();
		responseEntity = quizController.deleteQuiz(responseEntity.getBody().getId(), null);
		Assert.assertTrue(responseEntity.getBody().isSuccessfully());
	}

	private ResponseEntity<QitResponse> newQuizTest() {
		Quiz quiz = new QuizTest();
		return quizController.saveQuiz(quiz,null);
	}

	private ResponseEntity<QitResponse> newInterview() {
		Quiz quiz = new Interview();
		return quizController.saveQuiz(quiz,null);
	}

	private ResponseEntity<QitResponse> newQuestionnaire() {
		Quiz quiz = new Questionnaire();
		return quizController.saveQuiz(quiz, null);
	}
}
