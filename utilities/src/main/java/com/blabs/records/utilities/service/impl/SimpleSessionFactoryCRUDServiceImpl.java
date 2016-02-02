package com.blabs.records.utilities.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.blabs.records.utilities.dao.CRUDDao;
import com.blabs.records.utilities.service.CRUDService;

@Transactional(propagation=Propagation.REQUIRED)
public abstract class SimpleSessionFactoryCRUDServiceImpl<DAO extends CRUDDao<E, PK>, E, PK> implements CRUDService<E, PK>{

	protected DAO dao;
	
	public abstract void setDao(DAO dao);
	
	public void persist(E entity) {
		dao.persist(entity);
	}

	public E merge(E entity) {
		dao.merge(entity);

		return entity;
	}

	public void delete(E entity) {
		dao.delete(entity);
	}

	public E find(PK pk) {
		return dao.find(pk);
	}

	public List<E> findAll() {
		return dao.findAll();
	}
}