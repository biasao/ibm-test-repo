package com.ibm.watson.health.repository;

import org.springframework.data.repository.CrudRepository;

import com.ibm.watson.health.entity.InfantRecord;

public interface InfantRecordRepository extends CrudRepository<InfantRecord, Long> {

}
