package com.ibm.watson.health.utilities.service.impl;

import java.io.Serializable;
import java.util.List;

import com.ibm.watson.health.utilities.service.CrudService;
import com.ibm.watson.health.utilities.service.exception.DomainComponentException;

public abstract class AbstractCrudService<E, ID extends Serializable> implements CrudService<E, ID> {

    @Override
    public E findById(ID id) throws DomainComponentException {
        return getCrudRepository().findOne(id);
    }

    @Override
    public List<E> listAll() throws DomainComponentException {
        return (List<E>) getCrudRepository().findAll();
    }

    @Override
    public E save(E entity) throws DomainComponentException {
        return getCrudRepository().save(entity);
    }

    @Override
    public void delete(ID id) throws DomainComponentException {
        getCrudRepository().delete(id);       
    }
}
