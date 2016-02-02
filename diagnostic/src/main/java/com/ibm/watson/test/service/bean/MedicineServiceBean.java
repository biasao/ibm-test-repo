package com.ibm.watson.test.service.bean;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.blabs.records.utilities.service.impl.SimpleSessionFactoryCRUDServiceImpl;
import com.ibm.watson.test.dao.MedicineDao;
import com.ibm.watson.test.entities.Medicine;
import com.ibm.watson.test.service.MedicineService;

@Service
public class MedicineServiceBean extends SimpleSessionFactoryCRUDServiceImpl<MedicineDao, Medicine, Long> implements MedicineService {

	@Inject
	@Override
	public void setDao(MedicineDao dao) {
		super.dao = dao;
	}
}
