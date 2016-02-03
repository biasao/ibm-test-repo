package com.ibm.watson.health.utilities.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ibm.watson.health.utilities.service.exception.DomainComponentException;

/**
 * Interface for any CRUD service for the given entity E, with id of the type ID.
 * @param <E>
 * @param <ID>
 */
public interface CrudService<E, ID extends Serializable> {
	E findById(ID id) throws DomainComponentException;
	List<E> listAll() throws DomainComponentException;
	E save(E entity) throws DomainComponentException;
	void delete(ID id) throws DomainComponentException;
	CrudRepository<E, ID> getCrudRepository() throws DomainComponentException;
}
