package com.ibm.watson.health.service.bean;

import javax.inject.Named;

import com.ibm.watson.developer_cloud.concept_insights.v2.model.Graph;
import com.ibm.watson.developer_cloud.concept_insights.v2.model.Annotations;
import com.ibm.watson.developer_cloud.language_translation.v2.ConceptInsights;

@Named
public class ConceptInsightsServiceBean implements ConceptInsightsService {

	private static String USER = "033a8219-8a0a-4936-ad4a-756125aca777";
	private static String PASSWORD = "zvgt25wy2VVK";
	
	@Override
	Annotations conceptInsight(final String text) throws DomainComponentException;
		ConceptInsights service = new ConceptInsights();
		service.setUsernameAndPassword(USER, PASSWORD);

		Annotations annotations =
			service.annotateText(Graph.WIKIPEDIA,text);
	    
	    return annotations;
	}

}
