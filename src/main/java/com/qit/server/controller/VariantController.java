package com.qit.server.controller;

import com.qit.server.dto.QitResponse;
import com.qit.server.model.answer.Variant;
import com.qit.server.service.variant.VariantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/variant")
public class VariantController {

	@Autowired
	private VariantService variantService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Variant> getAllVariants() {
		return variantService.getAllVariants();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Variant getVariant(@PathVariable("id") Long id) {
		return variantService.getVariant(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<QitResponse> saveVariant(@RequestBody Variant variant) {
		return new ResponseEntity<>(variantService.save(variant), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<QitResponse> deleteVariant(@PathVariable("id") Long id) {
		return new ResponseEntity<QitResponse>(variantService.deleteById(id), HttpStatus.OK);
	}
}
