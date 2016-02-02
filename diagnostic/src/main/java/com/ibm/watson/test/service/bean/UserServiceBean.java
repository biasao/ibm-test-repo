package com.ibm.watson.test.service.bean;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.blabs.records.utilities.service.impl.SimpleSessionFactoryCRUDServiceImpl;
import com.ibm.watson.test.dao.UserProfileDao;
import com.ibm.watson.test.entities.UserProfile;
import com.ibm.watson.test.service.UserService;

@Service
public class UserServiceBean extends SimpleSessionFactoryCRUDServiceImpl<UserProfileDao, UserProfile, String> implements UserService {

	@Inject
	@Override
	public void setDao(UserProfileDao dao) {
		super.dao = dao;
	}
}
