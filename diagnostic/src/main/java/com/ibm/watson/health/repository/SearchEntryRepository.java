package com.ibm.watson.health.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ibm.watson.health.entity.SearchEntry;

public interface SearchEntryRepository extends MongoRepository<SearchEntry, String> {

	public SearchEntry findByFirstName(String firstName);
    public List<SearchEntry> findByLastName(String lastName);
}
