package com.ibm.watson.health.service.bean;

import com.ibm.watson.developer_cloud.language_translation.v2.LanguageTranslation;
import com.ibm.watson.developer_cloud.language_translation.v2.model.TranslationResult;
import com.ibm.watson.health.service.TranslateService;

public class TranslateServiceBean implements TranslateService {

	private static String USER = "01d82b3c-078f-47a0-8d68-1eb0997c64ba";
	private static String PASSWORD = "medroaU6j31p";
	
	@Override
	public TranslationResult translate(String text, String source, String target) {
		LanguageTranslation service = new LanguageTranslation();
	    service.setUsernameAndPassword(USER, PASSWORD);

	    TranslationResult translationResult = service.translate(text, source, target);
	    
	    return translationResult;
	}

}
