package com.ibm.watson.test.service.bean;

import javax.inject.Inject;

import com.blabs.records.utilities.service.impl.SimpleSessionFactoryCRUDServiceImpl;
import com.ibm.watson.test.dao.PatientDao;
import com.ibm.watson.test.entities.Patient;

public class PatientServiceBean extends SimpleSessionFactoryCRUDServiceImpl<PatientDao, Patient, Long>{

	@Inject
	@Override
	public void setDao(PatientDao dao) {
		super.dao = dao;
	}
}