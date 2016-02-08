package com.ibm.watson.health.resource.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.watson.developer_cloud.concept_insights.v2.model.Annotations;
import com.ibm.watson.health.service.ConceptInsightsService;
import com.ibm.watson.health.utilities.service.ResourceConstants;
import com.ibm.watson.health.utilities.service.exception.DomainComponentException;

@RestController
@RequestMapping("/conceptInsight")
public class ConceptInsightController {


	private static Logger logger = LoggerFactory
			.getLogger(ConceptInsightController.class);
	
	@Inject
	private ConceptInsightsService conceptInsightsService;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/{inputText}", method = RequestMethod.GET)
	@ApiOperation(value = "Returns concept insight of given input text.", notes = "Returns concept insight of given input text", response = Annotations.class, responseContainer = "Annotations")
	@ApiResponses(value = {
			@ApiResponse(code = ResourceConstants.CODE_401, message = ResourceConstants.CODE_401_TEXT),
			@ApiResponse(code = ResourceConstants.CODE_403, message = ResourceConstants.CODE_403_TEXT),
			@ApiResponse(code = ResourceConstants.CODE_404, message = "No concept insight could be found.") })
	ResponseEntity<?> conceptInsight(@PathVariable String inputText) {
		try {
			logger.debug("analysing concept insights for given input text: {}",
					inputText);
			Annotations annotations = this.conceptInsightsService
					.conceptInsight(inputText);

			if (annotations == null) {
				logger.debug("resulting concept insight analisys is null");
				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity(annotations, HttpStatus.OK);
		} catch (DomainComponentException e) {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
