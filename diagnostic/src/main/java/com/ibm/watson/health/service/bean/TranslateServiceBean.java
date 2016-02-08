package com.ibm.watson.health.service.bean;

import java.util.List;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ibm.watson.developer_cloud.language_translation.v2.LanguageTranslation;
import com.ibm.watson.developer_cloud.language_translation.v2.model.IdentifiableLanguage;
import com.ibm.watson.developer_cloud.language_translation.v2.model.IdentifiedLanguage;
import com.ibm.watson.developer_cloud.language_translation.v2.model.TranslationResult;
import com.ibm.watson.health.service.TranslateService;
import com.ibm.watson.health.utilities.service.exception.DomainComponentException;

@Named
public class TranslateServiceBean implements TranslateService {

	private static String USER = "01d82b3c-078f-47a0-8d68-1eb0997c64ba";
	private static String PASSWORD = "medroaU6j31p";
	
	private static Logger logger = LoggerFactory
			.getLogger(TranslateServiceBean.class);
	
	
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
	
	public Boolean isSupportedLanguage(String language) throws DomainComponentException {
		if(language == null) {
			logger.warn("language to be verified among supported languages is null.");
			return false;
		}
		
		final LanguageTranslation service = new LanguageTranslation();
	    service.setUsernameAndPassword(USER, PASSWORD);

		List<IdentifiableLanguage> identifiableLanguages = service.getIdentifiableLanguages();
		
		logger.info("supported languages are: ");
		for(final IdentifiableLanguage identifiableLanguage: identifiableLanguages) {
			logger.info("->{}", identifiableLanguage);
			if(language.equals(identifiableLanguage.getLanguage())) {
				return true;
			}
		}
		
		return false;
	}

}
