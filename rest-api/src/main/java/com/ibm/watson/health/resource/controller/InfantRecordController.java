package com.ibm.watson.health.resource.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

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

import com.ibm.watson.developer_cloud.concept_insights.v2.model.Annotations;
import com.ibm.watson.developer_cloud.language_translation.v2.model.TranslationResult;
import com.ibm.watson.developer_cloud.personality_insights.v2.model.Profile;
import com.ibm.watson.health.entity.InfantRecord;
import com.ibm.watson.health.service.ConceptInsightsService;
import com.ibm.watson.health.service.InfantRecordService;
import com.ibm.watson.health.service.PersonalityAnalisysService;
import com.ibm.watson.health.service.TranslateService;
import com.ibm.watson.health.utilities.service.ResourceConstants;
import com.ibm.watson.health.utilities.service.exception.DomainComponentException;

@RestController
@RequestMapping("/infantRecord")
public class InfantRecordController {

	@Inject
	private InfantRecordService infantRecordService;

	@Inject
	private PersonalityAnalisysService personalityAnalisysService;

	@Inject
	private TranslateService translateService;
	
	@Inject
	private ConceptInsightsService conceptInsightsService;

	private static Logger logger = LoggerFactory
			.getLogger(InfantRecordController.class);

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
			List<InfantRecord> infantRecords = this.infantRecordService
					.listAll();

			return new ResponseEntity(infantRecords, HttpStatus.OK);
		} catch (DomainComponentException e) {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/{inputText}", method = RequestMethod.GET)
	@ApiOperation(value = "Returns a profile of the personality analisys", notes = "Returns a profile of the personality analisys", response = Profile.class, responseContainer = "Profile")
	@ApiResponses(value = {
			@ApiResponse(code = ResourceConstants.CODE_401, message = ResourceConstants.CODE_401_TEXT),
			@ApiResponse(code = ResourceConstants.CODE_403, message = ResourceConstants.CODE_403_TEXT),
			@ApiResponse(code = ResourceConstants.CODE_404, message = "Profile could not be found.") })
	ResponseEntity<?> personalityInsight(@PathVariable String inputText) {

		try {
			logger.debug("analysing infant personality on input text: {}",
					inputText);
			Profile profile = this.personalityAnalisysService
					.analysePersonality(inputText);

			if (profile == null) {
				logger.debug("resulting analysis profile for input text is null");
				return new ResponseEntity(HttpStatus.NOT_FOUND);
			}

			return new ResponseEntity(profile, HttpStatus.OK);
		} catch (DomainComponentException e) {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/translate/{inputText}/{source}/{target}", method = RequestMethod.GET)
	@ApiOperation(value = "Returns a translation of given input text, from source to target language", notes = "Returns a translation of given input text, from source to target language", response = TranslationResult.class, responseContainer = "TranslationResult")
	@ApiResponses(value = {
			@ApiResponse(code = ResourceConstants.CODE_401, message = ResourceConstants.CODE_401_TEXT),
			@ApiResponse(code = ResourceConstants.CODE_403, message = ResourceConstants.CODE_403_TEXT),
			@ApiResponse(code = ResourceConstants.CODE_404, message = "Profile could not be found.") })
	ResponseEntity<?> translateText(@PathVariable String inputText,
			@PathVariable String source, @PathVariable String target) {

		try {
			logger.debug("analysing infant personality on input text: {}",
					inputText);
			TranslationResult translationResult = this.translateService
					.translate(inputText, source, target);

			if (translationResult == null) {
				logger.debug("resulting analysis profile for input text is null");
				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity(translationResult, HttpStatus.OK);
		} catch (DomainComponentException e) {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/conceptInsight/{inputText}", method = RequestMethod.GET)
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
