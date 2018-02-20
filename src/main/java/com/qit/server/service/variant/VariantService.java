package com.qit.server.service.variant;

import com.qit.server.dto.QitResponse;
import com.qit.server.model.answer.Variant;

public interface VariantService {
	Variant getVariant(Long id);
	QitResponse save(Variant variant);
	QitResponse delete(Variant variant);
}
