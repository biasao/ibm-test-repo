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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.watson.developer_cloud.language_translation.v2.model.IdentifiedLanguage;
import com.ibm.watson.developer_cloud.language_translation.v2.model.TranslationResult;
import com.ibm.watson.health.service.TranslateService;
import com.ibm.watson.health.utilities.service.ResourceConstants;
import com.ibm.watson.health.utilities.service.exception.DomainComponentException;

@RestController
@RequestMapping("/translate")
public class TranslateController {

	@Inject
	private TranslateService translateService;
	
	private static Logger logger = LoggerFactory
			.getLogger(TranslateController.class);

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/{inputText}/{source}/{target}", method = RequestMethod.GET)
	@ApiOperation(value = "Returns a translation of given input text, from source to target language", notes = "Returns a translation of given input text, from source to target language", response = TranslationResult.class, responseContainer = "TranslationResult")
	@ApiResponses(value = {
			@ApiResponse(code = ResourceConstants.CODE_401, message = ResourceConstants.CODE_401_TEXT),
			@ApiResponse(code = ResourceConstants.CODE_403, message = ResourceConstants.CODE_403_TEXT),
			@ApiResponse(code = ResourceConstants.CODE_404, message = "Profile could not be found.") })
	ResponseEntity<?> translateText(@PathVariable String inputText,
			@PathVariable String source, @PathVariable String target) {

		try {
			logger.debug("translating input text: {}; from: {}; to: {}",
					inputText, source, target);
			TranslationResult translationResult = this.translateService
					.translate(inputText, source, target);

			if (translationResult == null) {
				logger.debug("resulting translation is null");
				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity(translationResult, HttpStatus.OK);
		} catch (DomainComponentException e) {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/identify/{inputText}", method = RequestMethod.GET)
	@ApiOperation(value = "Identifies laguage of given input text.", notes = "Identifies laguage of given input text.", response = IdentifiedLanguage.class, responseContainer = "IdentifiedLanguage")
	@ApiResponses(value = {
			@ApiResponse(code = ResourceConstants.CODE_401, message = ResourceConstants.CODE_401_TEXT),
			@ApiResponse(code = ResourceConstants.CODE_403, message = ResourceConstants.CODE_403_TEXT),
			@ApiResponse(code = ResourceConstants.CODE_404, message = "Profile could not be found.") })
	ResponseEntity<?> identifyLanguage(@PathVariable String inputText) {

		try {
			logger.debug("identifying possible languages for given input text: {}",
					inputText);
			List<IdentifiedLanguage> identifiedLanguages = this.translateService
					.identifyLanguage(inputText);

			if (identifiedLanguages == null) {
				logger.debug("resulting identified languages is null");
				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity(identifiedLanguages, HttpStatus.OK);
		} catch (DomainComponentException e) {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
