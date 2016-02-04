package com.ibm.watson.health.resource.controller;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.watson.health.entity.InfantRecord;
import com.ibm.watson.health.service.InfantRecordService;
import com.ibm.watson.health.utilities.service.exception.DomainComponentException;

@RestController
public class GreetingController {

    @Inject
    private InfantRecordService infantRecordService;
    
    @RequestMapping("/greeting")
    public InfantRecord greeting(@RequestParam(value="name", defaultValue="World") String name) {
        InfantRecord infantRecord = new InfantRecord("Mateus", "Biasão");
    	
        InfantRecord lookedUpRecord = new InfantRecord();
        try {
        	infantRecord.setId("123");
        	infantRecord = infantRecordService.save(infantRecord);
        	
        	lookedUpRecord = infantRecordService.findById(infantRecord.getId());
		} catch (DomainComponentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    	return lookedUpRecord;
    }
}