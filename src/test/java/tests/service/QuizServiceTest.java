package tests.service;

import com.qit.server.dto.QitResponse;
import com.qit.server.model.quiz.Quiz;
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
		QitResponse qitResponse = newQuiz();
		Assert.assertTrue(qitResponse.isSuccessfully());
	}

	@Test
	public void deleteQuiz() {
		QitResponse qitResponse = newQuiz();
		Quiz quiz = quizService.getQuiz(qitResponse.getId());
		qitResponse = quizService.delete(quiz);
		Assert.assertTrue(qitResponse.isSuccessfully());
	}

	private QitResponse newQuiz() {
		Quiz quiz = new Quiz();
		return quizService.save(quiz);
	}
}
