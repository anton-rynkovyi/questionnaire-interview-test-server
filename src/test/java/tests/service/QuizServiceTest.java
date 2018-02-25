package tests.service;

import com.qit.server.dto.QitResponse;
import com.qit.server.model.quiz.Interview;
import com.qit.server.model.quiz.Questionnaire;
import com.qit.server.model.quiz.Quiz;
import com.qit.server.model.quiz.QuizTest;
import com.qit.server.service.quiz.impl.QuizServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tests.AbstractTest;

public class QuizServiceTest extends AbstractTest {

	@Autowired
	private QuizServiceImpl quizService;

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
		Quiz quiz = quizService.getOne(qitResponse.getId());
		qitResponse = quizService.delete(quiz);
		Assert.assertTrue(qitResponse.isSuccessfully());

		qitResponse = newQuestinnaire();
		quiz = quizService.getOne(qitResponse.getId());
		qitResponse = quizService.delete(quiz);
		Assert.assertTrue(qitResponse.isSuccessfully());

		qitResponse = newInterview();
		quiz = quizService.getOne(qitResponse.getId());
		qitResponse = quizService.delete(quiz);
		Assert.assertTrue(qitResponse.isSuccessfully());
	}

	@Test
	public void deleteQuizById() {
		QitResponse qitResponse = newTest();
		qitResponse = quizService.deleteById(qitResponse.getId());
		Assert.assertTrue(qitResponse.isSuccessfully());

		qitResponse = newQuestinnaire();
		qitResponse = quizService.deleteById(qitResponse.getId());
		Assert.assertTrue(qitResponse.isSuccessfully());

		qitResponse = newInterview();
		qitResponse = quizService.deleteById(qitResponse.getId());
		Assert.assertTrue(qitResponse.isSuccessfully());
	}

	private QitResponse newTest() {
		Quiz quiz = new QuizTest();
		return quizService.save(quiz);
	}

	private QitResponse newQuestinnaire() {
		Questionnaire questionnaire = new Questionnaire();
		questionnaire.setAnonymity(Boolean.FALSE);
		questionnaire.setAnswerLimit(5);
		questionnaire.setSummary("Nice");
		return quizService.save(questionnaire);
	}

	private QitResponse newInterview() {
		Interview interview = new Interview();
		interview.setMemberLimit(5);
		return quizService.save(interview);
	}
}
