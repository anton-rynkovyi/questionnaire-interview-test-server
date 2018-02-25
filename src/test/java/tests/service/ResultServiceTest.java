package tests.service;

import com.qit.server.dto.QitResponse;
import com.qit.server.model.quiz.Result;
import com.qit.server.service.result.ResultService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tests.AbstractTest;

public class ResultServiceTest extends AbstractTest {

	@Autowired
	private ResultService resultService;

	@Test
	public void getResult() {
		QitResponse qitResponse = newResult();
		Result result = resultService.getResult(qitResponse.getId());
		Assert.assertNotNull(result);
		result = resultService.getResult(null);
		Assert.assertNull(result);
	}

	@Test
	public void saveResult() {
		QitResponse qitResponse = newResult();
		Assert.assertNotNull(qitResponse);
		Assert.assertTrue(qitResponse.isSuccessfully());
		qitResponse = resultService.save(null);
		Assert.assertFalse(qitResponse.isSuccessfully());
	}

	@Test
	public void deleteResult() {
		QitResponse qitResponse = newResult();
		Assert.assertNotNull(qitResponse);
		Assert.assertNotNull(qitResponse.isSuccessfully());
		qitResponse = resultService.delete(resultService.getResult(qitResponse.getId()));
		Assert.assertTrue(qitResponse.isSuccessfully());
		qitResponse = resultService.delete(null);
		Assert.assertNotNull(qitResponse);
		Assert.assertFalse(qitResponse.isSuccessfully());
	}

	@Test
	public void deleteResultById() {
		QitResponse qitResponse = newResult();
		Assert.assertNotNull(qitResponse);
		Assert.assertNotNull(qitResponse.isSuccessfully());
		qitResponse = resultService.deleteById(qitResponse.getId());
		Assert.assertTrue(qitResponse.isSuccessfully());
		qitResponse = resultService.deleteById(null);
		Assert.assertNotNull(qitResponse);
		Assert.assertFalse(qitResponse.isSuccessfully());
	}

	private QitResponse newResult() {
		Result result = new Result();
		return resultService.save(result);
	}

}
