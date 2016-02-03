package com.ibm.watson.health.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ibm.watson.health.entity.InfantRecord;

public interface InfantRecordRepository extends MongoRepository<InfantRecord, Long> {

	public InfantRecord findByFirstName(String firstName);
    public List<InfantRecord> findByLastName(String lastName);
}
