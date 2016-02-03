package com.ibm.watson.health.service.bean;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.repository.CrudRepository;

import com.ibm.watson.health.entity.InfantRecord;
import com.ibm.watson.health.repository.InfantRecordRepository;
import com.ibm.watson.health.service.InfantRecordService;
import com.ibm.watson.health.utilities.service.exception.DomainComponentException;
import com.ibm.watson.health.utilities.service.impl.AbstractCrudService;

@Named
public class InfantRecordServiceBean extends AbstractCrudService<InfantRecord, Long> implements InfantRecordService {

	@Inject
	private InfantRecordRepository repository;
	
	@Override
	public CrudRepository<InfantRecord, Long> getCrudRepository()
			throws DomainComponentException {
		
		return repository;
	}

}
