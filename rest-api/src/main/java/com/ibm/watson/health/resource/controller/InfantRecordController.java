package com.ibm.watson.health.resource.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.watson.developer_cloud.personality_insights.v2.model.Profile;
import com.ibm.watson.health.entity.InfantRecord;
import com.ibm.watson.health.service.InfantRecordService;
import com.ibm.watson.health.service.PersonalityAnalisysService;
import com.ibm.watson.health.utilities.service.exception.DomainComponentException;

@RestController
@RequestMapping("/infantRecord")
public class InfantRecordController {

    @Inject
    private InfantRecordService infantRecordService;
    
    @Inject
    private PersonalityAnalisysService personalityAnalisysService;
    
    private static Logger logger =  LoggerFactory.getLogger(InfantRecordController.class);
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(method = RequestMethod.POST)
	ResponseEntity<?> add(@RequestBody InfantRecord infantRecord) {
    	
		try {
			this.infantRecordService.save(infantRecord);
			    	
	    	return new ResponseEntity(null, HttpStatus.CREATED);
		} catch (DomainComponentException e) {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(method = RequestMethod.GET)
	ResponseEntity<?> readAll() {
    	
		try {
			List<InfantRecord> infantRecords = this.infantRecordService.listAll();
	    	
	    	return new ResponseEntity(infantRecords, HttpStatus.OK);
		} catch (DomainComponentException e) {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @RequestMapping(value = "/{inputText}", method = RequestMethod.GET)
    ResponseEntity<?> personalityInsight(@PathVariable String inputText) {
    	
		try {
			logger.debug("analysing infant personality on input text: {}", inputText);
			Profile profile = this.personalityAnalisysService.analysePersonality(inputText);
			
			if (profile == null) {
				logger.debug("resulting analysis profile for input text is null");
				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}
	    	
	    	return new ResponseEntity(profile, HttpStatus.OK);
		} catch (DomainComponentException e) {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
