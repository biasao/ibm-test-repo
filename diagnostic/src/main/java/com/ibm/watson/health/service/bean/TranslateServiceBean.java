package com.ibm.watson.health.service.bean;

import java.util.List;

import javax.inject.Named;

import com.ibm.watson.developer_cloud.language_translation.v2.LanguageTranslation;
import com.ibm.watson.developer_cloud.language_translation.v2.model.IdentifiedLanguage;
import com.ibm.watson.developer_cloud.language_translation.v2.model.TranslationResult;
import com.ibm.watson.health.service.TranslateService;
import com.ibm.watson.health.utilities.service.exception.DomainComponentException;

@Named
public class TranslateServiceBean implements TranslateService {

	private static String USER = "01d82b3c-078f-47a0-8d68-1eb0997c64ba";
	private static String PASSWORD = "medroaU6j31p";
	
	@Override
	public TranslationResult translate(final String text, final String source, final String target) {
		final LanguageTranslation service = new LanguageTranslation();
	    service.setUsernameAndPassword(USER, PASSWORD);

	    final TranslationResult translationResult = service.translate(text, source, target);
	    
	    return translationResult;
	}
	
	@Override
	public List<IdentifiedLanguage> identifyLanguage(final String text) throws DomainComponentException {
		final LanguageTranslation service = new LanguageTranslation();
	    service.setUsernameAndPassword(USER, PASSWORD);

	    final List<IdentifiedLanguage> identifiedLanguages = service.identify(text);
	    
	    return identifiedLanguages;
	}

}
