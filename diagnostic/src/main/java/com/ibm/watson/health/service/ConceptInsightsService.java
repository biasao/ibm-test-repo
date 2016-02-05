package com.ibm.watson.health.service;

import com.ibm.watson.developer_cloud.concept_insights.v2.model.Annotations;
import com.ibm.watson.health.utilities.service.exception.DomainComponentException;

public interface ConceptInsightsService {

	Annotations conceptInsight(final String text) throws DomainComponentException;
}
