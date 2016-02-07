package com.ibm.watson.health.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ibm.watson.health.entity.SearchEntry;

public interface SearchEntryRepository extends MongoRepository<SearchEntry, String> {

	public List<SearchEntry> findByEntry(String entry);
	public List<SearchEntry> findBySourceLanguage(String entry);

}
