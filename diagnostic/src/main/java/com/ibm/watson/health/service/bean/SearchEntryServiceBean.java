package com.ibm.watson.health.service.bean;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.repository.CrudRepository;

import com.ibm.watson.health.entity.SearchEntry;
import com.ibm.watson.health.repository.SearchEntryRepository;
import com.ibm.watson.health.service.SearchEntryService;
import com.ibm.watson.health.utilities.service.exception.DomainComponentException;
import com.ibm.watson.health.utilities.service.impl.AbstractCrudService;

@Named
public class SearchEntryServiceBean extends AbstractCrudService<SearchEntry, String> implements SearchEntryService {

	@Inject
	private SearchEntryRepository repository;
	
	@Override
	public CrudRepository<SearchEntry, String> getCrudRepository()
			throws DomainComponentException {
		
		return repository;
	}

}
