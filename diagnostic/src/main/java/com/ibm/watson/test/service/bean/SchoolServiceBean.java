package com.ibm.watson.test.service.bean;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.blabs.records.utilities.service.impl.SimpleSessionFactoryCRUDServiceImpl;
import com.ibm.watson.test.dao.SchoolDao;
import com.ibm.watson.test.entities.School;
import com.ibm.watson.test.service.SchoolService;

@Service
public class SchoolServiceBean extends SimpleSessionFactoryCRUDServiceImpl<SchoolDao, School, Long> implements SchoolService {

	@Inject
	@Override
	public void setDao(SchoolDao dao) {
		super.dao = dao;
	}
}
