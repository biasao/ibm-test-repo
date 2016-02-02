package com.ibm.watson.test.service;

import java.util.List;

import com.blabs.records.utilities.service.CRUDService;
import com.ibm.watson.test.entities.InfantRecord;
import com.ibm.watson.test.entities.UserProfile;

public interface RecordService extends CRUDService<InfantRecord, Long> {
	List<InfantRecord> findByUser(final UserProfile userProfile);
}
