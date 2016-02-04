package com.ibm.watson.health.resource.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ibm.watson.health.entity.InfantRecord;
import com.ibm.watson.health.service.InfantRecordService;
import com.ibm.watson.health.utilities.service.exception.DomainComponentException;

@RestController
public class InfantRecordController {

    @Inject
    private InfantRecordService infantRecordService;
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(path="/infantRecord", method = RequestMethod.POST)
	ResponseEntity<?> add(@RequestBody InfantRecord infantRecord) {
    	
		try {
			this.infantRecordService.save(infantRecord);
			    	
	    	return new ResponseEntity(null, HttpStatus.CREATED);
		} catch (DomainComponentException e) {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(path="/infantRecord", method = RequestMethod.GET)
	ResponseEntity<?> readAll() {
    	
		try {
			List<InfantRecord> infantRecords = this.infantRecordService.listAll();
	    	
	    	return new ResponseEntity(infantRecords, HttpStatus.OK);
		} catch (DomainComponentException e) {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}