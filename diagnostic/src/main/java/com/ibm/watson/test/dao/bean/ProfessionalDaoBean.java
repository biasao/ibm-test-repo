package com.ibm.watson.test.dao.bean;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import com.blabs.records.utilities.dao.impl.SimpleSessionFactoryCRUDDao;
import com.ibm.watson.test.dao.ProfessionalDao;
import com.ibm.watson.test.entities.Professional;

@Service
public class ProfessionalDaoBean extends SimpleSessionFactoryCRUDDao<Professional, Long> implements ProfessionalDao {
	
	@Inject
    public void setSessionFactory(SessionFactory sessionFactory) {
        super.sessionFactory = sessionFactory;
    }

	@Override
	public Class<Professional> getMyType() {
		return Professional.class;
	}
}
