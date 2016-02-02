package com.ibm.watson.test.dao.bean;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import com.blabs.records.utilities.dao.impl.SimpleSessionFactoryCRUDDao;
import com.ibm.watson.test.dao.UserProfileDao;
import com.ibm.watson.test.entities.UserProfile;

@Service
public class UserProfileDaoBean extends SimpleSessionFactoryCRUDDao<UserProfile, String> implements UserProfileDao {
	
	@Inject
    public void setSessionFactory(SessionFactory sessionFactory) {
        super.sessionFactory = sessionFactory;
    }

	@Override
	public Class<UserProfile> getMyType() {
		return UserProfile.class;
	}
}
