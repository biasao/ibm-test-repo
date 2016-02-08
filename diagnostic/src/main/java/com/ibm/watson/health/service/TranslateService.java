package com.ibm.watson.health.service;

import java.util.List;

import com.ibm.watson.developer_cloud.language_translation.v2.model.IdentifiedLanguage;
import com.ibm.watson.developer_cloud.language_translation.v2.model.TranslationResult;
import com.ibm.watson.health.utilities.service.exception.DomainComponentException;

public interface TranslateService {

	TranslationResult translate(final String text,final String source,final String target) throws DomainComponentException;
	List<IdentifiedLanguage> identifyLanguage(final String text) throws DomainComponentException;
	Boolean isSupportedLanguage(String language) throws DomainComponentException;
}
