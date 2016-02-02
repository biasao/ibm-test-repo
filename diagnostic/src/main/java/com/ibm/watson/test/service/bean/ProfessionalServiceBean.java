package com.ibm.watson.test.service.bean;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.blabs.records.utilities.service.impl.SimpleSessionFactoryCRUDServiceImpl;
import com.ibm.watson.test.dao.ProfessionalDao;
import com.ibm.watson.test.entities.Professional;
import com.ibm.watson.test.service.ProfessionalService;

@Service
public class ProfessionalServiceBean extends SimpleSessionFactoryCRUDServiceImpl<ProfessionalDao, Professional, Long> implements ProfessionalService {

	@Inject
	@Override
	public void setDao(ProfessionalDao dao) {
		super.dao = dao;
	}
}
