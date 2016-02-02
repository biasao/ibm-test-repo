package com.ibm.watson.test.dao.bean;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import com.blabs.records.utilities.dao.impl.SimpleSessionFactoryCRUDDao;
import com.ibm.watson.test.dao.MedicineDao;
import com.ibm.watson.test.entities.Medicine;

@Service
public class MedicineDaoBean extends SimpleSessionFactoryCRUDDao<Medicine, Long> implements MedicineDao {
	
	@Inject
    public void setSessionFactory(SessionFactory sessionFactory) {
        super.sessionFactory = sessionFactory;
    }

	@Override
	public Class<Medicine> getMyType() {
		return Medicine.class;
	}
}
