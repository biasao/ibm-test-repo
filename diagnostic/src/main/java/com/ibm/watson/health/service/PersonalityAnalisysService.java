package com.ibm.watson.health.service;

import com.ibm.watson.developer_cloud.personality_insights.v2.model.Profile;
import com.ibm.watson.health.utilities.service.exception.DomainComponentException;


public interface PersonalityAnalisysService {

	Profile analysePersonality(String inputText) throws DomainComponentException;
}
