package com.blabs.records.utilities.service;

import java.util.List;

public interface CRUDService<E, PK> {
	public void persist(E entity);
	public E merge(E entity);
	public void delete(E entity);
	public E find(PK id);
	public List<E> findAll();
}
