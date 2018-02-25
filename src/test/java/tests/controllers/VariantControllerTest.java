package tests.controllers;

import com.qit.server.controller.VariantController;
import com.qit.server.dto.QitResponse;
import com.qit.server.model.answer.Variant;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import tests.AbstractTest;

import java.util.List;

public class VariantControllerTest extends AbstractTest {

	@Autowired
	private VariantController variantController;

	@Test
	public void getAllVariants() {
		ResponseEntity<QitResponse> responseEntity = newVariant();
		List<Variant> variants = variantController.getAllVariants();
		Assert.assertNotNull(variants);
	}

	@Test
	public void getVariant() {
		ResponseEntity<QitResponse> responseEntity = newVariant();
		Variant variant = variantController.getVariant(responseEntity.getBody().getId());
		Assert.assertNotNull(variant);
	}

	@Test
	public void saveVariant() {
		ResponseEntity<QitResponse> responseEntity = newVariant();
		Assert.assertTrue(responseEntity.getBody().isSuccessfully());
	}

	@Test
	public void deleteVariant() {
		ResponseEntity<QitResponse> responseEntity = newVariant();
		responseEntity = variantController.deleteVariant(responseEntity.getBody().getId());
		Assert.assertTrue(responseEntity.getBody().isSuccessfully());
	}

	private ResponseEntity<QitResponse> newVariant() {
		return variantController.saveVariant(new Variant());
	}

}
