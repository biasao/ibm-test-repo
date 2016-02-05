package com.ibm.watson.health.service;

import com.ibm.watson.developer_cloud.language_translation.v2.model.TranslationResult;
import com.ibm.watson.health.utilities.service.exception.DomainComponentException;

public interface TranslateService {

	TranslationResult translate(final String text,final String source,final String target) throws DomainComponentException;
}
