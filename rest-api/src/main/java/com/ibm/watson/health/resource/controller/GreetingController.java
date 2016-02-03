package com.ibm.watson.health.resource.controller;

import java.util.concurrent.atomic.AtomicLong;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.watson.health.entity.InfantRecord;
import com.ibm.watson.health.resource.Greeting;
import com.ibm.watson.health.service.InfantRecordService;
import com.ibm.watson.health.utilities.service.exception.DomainComponentException;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Inject
    private InfantRecordService infantRecordService;
    
    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        final InfantRecord infantRecord = new InfantRecord("Mateus", "Biasão");
    	
        try {
			infantRecordService.save(infantRecord);
		} catch (DomainComponentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    	return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
}