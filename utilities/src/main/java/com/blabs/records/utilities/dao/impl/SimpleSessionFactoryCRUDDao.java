package com.blabs.records.utilities.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.blabs.records.utilities.dao.CRUDDao;

@Transactional(propagation=Propagation.REQUIRED)
public abstract class SimpleSessionFactoryCRUDDao<E, PK extends Serializable> implements CRUDDao<E, PK>{

	protected SessionFactory sessionFactory;
	
	public abstract void setSessionFactory(SessionFactory sessionFactory);
	public abstract Class<E> getMyType();
	
	public void persist(E entity) {
		sessionFactory.getCurrentSession().save(entity);
	}

	public E merge(E entity) {
		sessionFactory.getCurrentSession().merge(entity);
		
		return entity;
	}

	public void delete(E entity) {
		sessionFactory.getCurrentSession().delete(entity);
	}

	@SuppressWarnings("unchecked")
	public E find(PK id) {
		E entity = (E)sessionFactory.getCurrentSession().get(getMyType(), id);
		return entity;
	}

	@SuppressWarnings("unchecked")
	public List<E> findAll() {
		List<E> entities;
		Query query = sessionFactory.getCurrentSession().createQuery("from " + getMyType().getName());
		entities = query.list();
		
		return entities;
	}

}
