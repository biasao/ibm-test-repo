package com.ibm.watson.test.dao;

import java.util.List;

import com.blabs.records.utilities.dao.CRUDDao;
import com.ibm.watson.test.entities.InfantRecord;
import com.ibm.watson.test.entities.UserProfile;

public interface InfantRecordDao  extends CRUDDao<InfantRecord, Long>{
	List<InfantRecord> findByUser(final UserProfile userProfile);
}
