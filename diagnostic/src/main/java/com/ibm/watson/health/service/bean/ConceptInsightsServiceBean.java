package com.ibm.watson.health.service.bean;

import javax.inject.Named;

import com.ibm.watson.developer_cloud.concept_insights.v2.ConceptInsights;
import com.ibm.watson.developer_cloud.concept_insights.v2.model.Annotations;
import com.ibm.watson.developer_cloud.concept_insights.v2.model.Graph;
import com.ibm.watson.health.service.ConceptInsightsService;
import com.ibm.watson.health.utilities.service.exception.DomainComponentException;

@Named
public class ConceptInsightsServiceBean implements ConceptInsightsService {

	private static String USER = "033a8219-8a0a-4936-ad4a-756125aca777";
	private static String PASSWORD = "zvgt25wy2VVK";
	
	@Override
	public Annotations conceptInsight(final String text) throws DomainComponentException {
		ConceptInsights service = new ConceptInsights();
		service.setUsernameAndPassword(USER, PASSWORD);

		Annotations annotations =
			service.annotateText(Graph.WIKIPEDIA,text);
	    
	    return annotations;
	}

}
