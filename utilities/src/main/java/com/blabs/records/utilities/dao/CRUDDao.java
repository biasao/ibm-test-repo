package com.blabs.records.utilities.dao;

import java.util.List;

public interface CRUDDao<E,PK> {
	public void persist(E entity);
	public E merge(E entity);
	public void delete(E entity);
	public E find(PK id);
	public List<E> findAll();
}
