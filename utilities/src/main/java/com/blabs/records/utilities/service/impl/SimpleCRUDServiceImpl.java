package com.blabs.records.utilities.service.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.blabs.records.utilities.service.CRUDService;

public abstract class SimpleCRUDServiceImpl<E, ID> implements CRUDService<E, ID> {

	private EntityManager em;

	@PostConstruct
	private void init() {
		em = getEntityManager();
	}
	
	public void persist(E entity) {
		em.persist(entity);
		em.flush();
	}

	public E merge(E entity) {
		em.refresh(entity);
		return em.merge(entity);
	}

	public void delete(E entity) {
		em.remove(entity);
	}

	public E find(ID id) {
		return em.find(getType(), id);
	}

	@SuppressWarnings("unchecked")
	public List<E> findAll() {
		Query query = em.createQuery("SELECT e FROM " + getType().getName() + " e");
		return (List<E>) query.getResultList();
	}

	private Class<E> getType() {
		final ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
		@SuppressWarnings("unchecked")
		Class<E> theType = (Class<E>) type.getActualTypeArguments()[0];
		return theType;
	}
	
	protected abstract EntityManager getEntityManager(); 
}
