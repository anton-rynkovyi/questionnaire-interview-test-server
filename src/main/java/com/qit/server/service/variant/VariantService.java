package com.qit.server.service.variant;

import com.qit.server.dto.QitResponse;
import com.qit.server.model.answer.Variant;

import java.util.List;

public interface VariantService {
	List<Variant> getAllVariants();
	Variant getVariant(Long id);
	QitResponse save(Variant variant);
	QitResponse delete(Variant variant);
	QitResponse deleteById(Long id);
}
