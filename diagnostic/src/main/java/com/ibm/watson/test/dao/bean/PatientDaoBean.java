package com.ibm.watson.test.dao.bean;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import com.blabs.records.utilities.dao.impl.SimpleSessionFactoryCRUDDao;
import com.ibm.watson.test.dao.PatientDao;
import com.ibm.watson.test.entities.Patient;

@Service
public class PatientDaoBean extends SimpleSessionFactoryCRUDDao<Patient, Long> implements PatientDao {
	
	@Inject
    public void setSessionFactory(SessionFactory sessionFactory) {
        super.sessionFactory = sessionFactory;
    }

	@Override
	public Class<Patient> getMyType() {
		return Patient.class;
	}
}
