package com.ibm.watson.health.service.bean;

import javax.inject.Named;

import com.ibm.watson.developer_cloud.personality_insights.v2.PersonalityInsights;
import com.ibm.watson.developer_cloud.personality_insights.v2.model.Profile;
import com.ibm.watson.health.service.PersonalityAnalisysService;

@Named
public class InfantPersonalityAnalisysServiceBean implements PersonalityAnalisysService {

	public Profile analysePersonality(String inputText) {

		PersonalityInsights service = new PersonalityInsights();
	    service.setUsernameAndPassword("a9a2a133-2c7a-40ac-a582-01b7aa35af6a", "iWjveItjSv91");

	    return service.getProfile(inputText);
	}
}
