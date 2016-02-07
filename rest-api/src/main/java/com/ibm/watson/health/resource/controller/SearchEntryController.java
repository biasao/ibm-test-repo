package com.ibm.watson.health.resource.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.watson.health.entity.SearchEntry;
import com.ibm.watson.health.service.SearchEntryService;
import com.ibm.watson.health.utilities.service.exception.DomainComponentException;

@RestController
@RequestMapping("/searchEntry")
public class SearchEntryController {

	@Inject
	private SearchEntryService searchEntryService;

	private static Logger logger = LoggerFactory
			.getLogger(SearchEntryController.class);

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(method = RequestMethod.POST)
	ResponseEntity<?> add(@RequestBody SearchEntry searchEntry) {

		logger.debug("storing search entry: {}", searchEntry);
		try {
			this.searchEntryService.save(searchEntry);

			return new ResponseEntity(null, HttpStatus.CREATED);
		} catch (DomainComponentException e) {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(method = RequestMethod.GET)
	ResponseEntity<?> readAll() {

		logger.debug("finding all searched entries");
		try {
			List<SearchEntry> entries = this.searchEntryService
					.listAll();

			return new ResponseEntity(entries, HttpStatus.OK);
		} catch (DomainComponentException e) {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
