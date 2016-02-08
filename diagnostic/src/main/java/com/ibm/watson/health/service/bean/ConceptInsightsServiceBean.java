package com.ibm.watson.health.service.bean;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ibm.watson.developer_cloud.concept_insights.v2.ConceptInsights;
import com.ibm.watson.developer_cloud.concept_insights.v2.model.Annotations;
import com.ibm.watson.developer_cloud.concept_insights.v2.model.Graph;
import com.ibm.watson.developer_cloud.concept_insights.v2.model.ScoredConcept;
import com.ibm.watson.developer_cloud.language_translation.v2.model.IdentifiedLanguage;
import com.ibm.watson.developer_cloud.language_translation.v2.model.TranslationResult;
import com.ibm.watson.health.entity.SearchEntry;
import com.ibm.watson.health.service.ConceptInsightsService;
import com.ibm.watson.health.service.SearchEntryService;
import com.ibm.watson.health.service.TranslateService;
import com.ibm.watson.health.utilities.service.exception.DomainComponentException;

@Named
public class ConceptInsightsServiceBean implements ConceptInsightsService {

	private static String USER = "033a8219-8a0a-4936-ad4a-756125aca777";
	private static String PASSWORD = "zvgt25wy2VVK";

	private static Logger logger = LoggerFactory
			.getLogger(ConceptInsightsServiceBean.class);
	
	@Inject
	private SearchEntryService searchEntryService;
	
	@Inject
	private TranslateService translateService;
	
	private static final String EN = "en";
	
	@Override
	public Annotations conceptInsight(final String text) throws DomainComponentException {
		logger.debug("Input text for concept insights: {}", text);
		String identifiedLanguage = identifyMostLikelyLanguage(text);
		
		final String translatedText = translateToEnglishForBetterResult(identifiedLanguage, text);
		
		final ConceptInsights service = new ConceptInsights();
		service.setUsernameAndPassword(USER, PASSWORD);

		Annotations annotations =
			service.annotateText(Graph.WIKIPEDIA,text);
	    
		final List<String> conceptInsights = retrieveConceptInsights(annotations);
		
		logger.debug("Store log entry: {}|{}|{}", text, identifiedLanguage, translatedText);
		searchEntryService.save(new SearchEntry(text, identifiedLanguage, translatedText, conceptInsights));
		
	    return annotations;
	}

	private List<String> retrieveConceptInsights(Annotations annotations) {
		final List<String> concepts = new ArrayList<String>();
		for(ScoredConcept concept : annotations.getAnnotations()) {
			final String conceptStr = concept.getConcept().getLabel();
			concepts.add(conceptStr);
			logger.debug("Concept insight: {}", conceptStr);
		}
		
		return concepts;
	}

	private String translateToEnglishForBetterResult(String identifiedLanguage,
			String text) throws DomainComponentException {

		if (EN.equals(identifiedLanguage)) {
			logger.debug("No translation needed, text already in English.");
			return text;
		}
		
		final TranslationResult translationResult = translateService.translate(text, identifiedLanguage, EN);
		
		if (translationResult.getTranslations() == null || translationResult.getTranslations().isEmpty()) {
			logger.warn("no translation found for: {}", text);
			return null;
		}
		
		final String topTranslatedText = translationResult.getTranslations().get(0).getTranslation();
		logger.debug("Most likely translation: {}", topTranslatedText);
		
		return topTranslatedText;
	}

	private String identifyMostLikelyLanguage(final String text)
			throws DomainComponentException {
		List<IdentifiedLanguage> identifiedLanguages = translateService.identifyLanguage(text);
		
		if (identifiedLanguages == null || identifiedLanguages.isEmpty()) {
			return null;
		}
		
		final String mostLikelyLanguage = identifiedLanguages.get(0).getLanguage();
		logger.debug("Most likely input language: {}", mostLikelyLanguage);
		
		return mostLikelyLanguage;
	}

}
