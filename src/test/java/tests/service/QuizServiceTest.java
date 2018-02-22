package tests.service;

import com.qit.server.dto.QitResponse;
import com.qit.server.model.quiz.Interview;
import com.qit.server.model.quiz.Questionnnaire;
import com.qit.server.model.quiz.Quiz;
import com.qit.server.model.quiz.QuizTest;
import com.qit.server.service.quiz.QuizService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tests.AbstractTest;

public class QuizServiceTest extends AbstractTest {

	@Autowired
	private QuizService quizService;

	@Test
	public void createQuiz() {
		QitResponse qitResponse = newTest();
		Assert.assertTrue(qitResponse.isSuccessfully());
		qitResponse = newInterview();
		Assert.assertTrue(qitResponse.isSuccessfully());
		qitResponse = newQuestinnaire();
		Assert.assertTrue(qitResponse.isSuccessfully());
	}

	@Test
	public void deleteQuiz() {
		QitResponse qitResponse = newTest();
		Quiz quiz = quizService.getQuiz(qitResponse.getId());
		qitResponse = quizService.delete(quiz);
		Assert.assertTrue(qitResponse.isSuccessfully());

		qitResponse = newQuestinnaire();
		quiz = quizService.getQuiz(qitResponse.getId());
		qitResponse = quizService.delete(quiz);
		Assert.assertTrue(qitResponse.isSuccessfully());

		qitResponse = newInterview();
		quiz = quizService.getQuiz(qitResponse.getId());
		qitResponse = quizService.delete(quiz);
		Assert.assertTrue(qitResponse.isSuccessfully());
	}

	private QitResponse newTest() {
		Quiz quiz = new QuizTest();
		return quizService.save(quiz);
	}

	private QitResponse newQuestinnaire() {
		Quiz quiz = new Questionnnaire();
		return quizService.save(quiz);
	}

	private QitResponse newInterview() {
		Quiz quiz = new Interview();
		return quizService.save(quiz);
	}
}
