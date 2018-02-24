package com.qit.server.service.variant;

import com.qit.server.dao.VariantDao;
import com.qit.server.dto.QitResponse;
import com.qit.server.model.answer.Variant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VariantServiceImpl implements VariantService {

	@Autowired
	private VariantDao variantDao;

	@Override
	public List<Variant> getAllVariants() {
		return variantDao.findAll();
	}

	@Override
	public Variant getVariant(Long id) {
		return variantDao.getOne(id);
	}

	@Override
	public QitResponse save(Variant variant) {
		QitResponse qitResponse = new QitResponse();
		if (variant != null) {
			variant = variantDao.save(variant);
			qitResponse.setId(variant.getId());
			qitResponse.successed();
		} else {
			qitResponse.failed();
		}
		return qitResponse;
	}

	@Override
	public QitResponse delete(Variant variant) {
		QitResponse qitResponse = new QitResponse();
		if (variant != null) {
			qitResponse.setId(variant.getId());
			variantDao.delete(variant);
			qitResponse.successed();
		} else {
			qitResponse.failed();
		}
		return qitResponse;
	}

	@Override
	public QitResponse deleteById(Long id) {
		QitResponse qitResponse = new QitResponse();
		if (id != null) {
			variantDao.delete(id);
			qitResponse.successed();
		} else {
			qitResponse.failed();
		}
		return qitResponse;
	}
}
