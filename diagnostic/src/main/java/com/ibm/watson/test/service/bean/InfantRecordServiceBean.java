package com.ibm.watson.test.service.bean;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.blabs.records.utilities.service.impl.SimpleSessionFactoryCRUDServiceImpl;
import com.ibm.watson.test.dao.InfantRecordDao;
import com.ibm.watson.test.entities.InfantRecord;
import com.ibm.watson.test.entities.UserProfile;
import com.ibm.watson.test.service.RecordService;

@Service
public class InfantRecordServiceBean extends SimpleSessionFactoryCRUDServiceImpl<InfantRecordDao, InfantRecord, Long> implements RecordService {

	@Inject
	@Override
	public void setDao(InfantRecordDao dao) {
		super.dao = dao;
	}
	
	public List<InfantRecord> findByUser(final UserProfile userProfile) {
		return dao.findByUser(userProfile);
	}
}