package tests.service;

import com.qit.server.dto.Response;
import com.qit.server.model.question.Question;
import com.qit.server.model.question.QuestionType;
import com.qit.server.service.QuestionService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tests.AbstractTest;

public class QuestionServiceTest extends AbstractTest {

	@Autowired
	private QuestionService questionService;

	@Test
	public void createQuestion() {
		Question question = new Question();
		question.setNecessary(true);
		question.setQuestionType(QuestionType.ONLY_ONE);
		Response response = questionService.createQuestion(question);
		Assert.assertTrue(response.isSuccessfully());
	}

}
