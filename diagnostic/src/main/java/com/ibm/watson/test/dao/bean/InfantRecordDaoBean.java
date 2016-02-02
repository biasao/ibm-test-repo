package com.ibm.watson.test.dao.bean;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import com.blabs.records.utilities.dao.impl.SimpleSessionFactoryCRUDDao;
import com.ibm.watson.test.dao.InfantRecordDao;
import com.ibm.watson.test.entities.InfantRecord;
import com.ibm.watson.test.entities.UserProfile;

@Service
public class InfantRecordDaoBean extends SimpleSessionFactoryCRUDDao<InfantRecord, Long> implements InfantRecordDao {
	
	@Inject
    public void setSessionFactory(SessionFactory sessionFactory) {
        super.sessionFactory = sessionFactory;
    }

	@Override
	public Class<InfantRecord> getMyType() {
		return InfantRecord.class;
	}

	@SuppressWarnings("unchecked")
	public List<InfantRecord> findByUser(final UserProfile userProfile) {
		Query query = sessionFactory.getCurrentSession().createQuery("from InfantRecord ir where ir.userProfile = :userProfile")
				.setEntity("userProfile", userProfile);
		return query.list();
	}
}
