package com.ibm.watson.test.dao.bean;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import com.blabs.records.utilities.dao.impl.SimpleSessionFactoryCRUDDao;
import com.ibm.watson.test.dao.SchoolDao;
import com.ibm.watson.test.entities.School;

@Service
public class SchoolDaoBean extends SimpleSessionFactoryCRUDDao<School, Long> implements SchoolDao {
	
	@Inject
    public void setSessionFactory(SessionFactory sessionFactory) {
        super.sessionFactory = sessionFactory;
    }

	@Override
	public Class<School> getMyType() {
		return School.class;
	}
}
