package tests.service;

import com.qit.server.dto.QitResponse;
import com.qit.server.model.answer.Variant;
import com.qit.server.service.variant.VariantService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tests.AbstractTest;

public class VariantServiceTest extends AbstractTest {

	@Autowired
	private VariantService variantService;

	@Test
	public void getVariant() {
		QitResponse qitResponse = newVariant();
		Variant variant = variantService.getVariant(qitResponse.getId());
		Assert.assertNotNull(variant);
	}

	@Test
	public void saveVariant() {
		QitResponse qitResponse = newVariant();
		Assert.assertTrue(qitResponse.isSuccessfully());
		qitResponse = variantService.save(null);
		Assert.assertFalse(qitResponse.isSuccessfully());
	}

	@Test
	public void deleteVariant() {
		QitResponse qitResponse = newVariant();
		Variant variant = variantService.getVariant(qitResponse.getId());
		qitResponse = variantService.delete(variant);
		Assert.assertTrue(qitResponse.isSuccessfully());
		qitResponse = variantService.delete(null);
		Assert.assertFalse(qitResponse.isSuccessfully());
	}

	@Test
	public void deleteVariantById() {
		QitResponse qitResponse = newVariant();
		qitResponse = variantService.deleteById(qitResponse.getId());
		Assert.assertTrue(qitResponse.isSuccessfully());
		qitResponse = variantService.delete(null);
		Assert.assertFalse(qitResponse.isSuccessfully());
	}

	private QitResponse newVariant() {
		Variant variant = new Variant();
		return variantService.save(variant);
	}

}
