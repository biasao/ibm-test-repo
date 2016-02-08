package com.ibm.watson.health.entity;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;

public class SearchEntry implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5090526238868798208L;
	
	@Id
	private String id;

    private String entry;
    private String sourceLanguage;
    private String translatedEntry;
    private List<String> conceptInsights;

    
    public SearchEntry() {}

	public SearchEntry(String entry, String sourceLanguage) {
		super();
		this.entry = entry;
		this.sourceLanguage = sourceLanguage;
	}

	public SearchEntry(String entry, String sourceLanguage,
			String translatedEntry, List<String> conceptInsights) {
		super();
		this.entry = entry;
		this.sourceLanguage = sourceLanguage;
		this.translatedEntry = translatedEntry;
		this.conceptInsights = conceptInsights;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEntry() {
		return entry;
	}

	public void setEntry(String entry) {
		this.entry = entry;
	}

	public String getSourceLanguage() {
		return sourceLanguage;
	}

	public void setSourceLanguage(String sourceLanguage) {
		this.sourceLanguage = sourceLanguage;
	}

	public String getTranslatedEntry() {
		return translatedEntry;
	}

	public void setTranslatedEntry(String translatedEntry) {
		this.translatedEntry = translatedEntry;
	}

	public List<String> getConceptInsights() {
		return conceptInsights;
	}

	public void setConceptInsights(List<String> conceptInsights) {
		this.conceptInsights = conceptInsights;
	}
	
	public String getConceptInsightsStr() {
		if (conceptInsights == null) {
			return "";
		}
		
		String conceptInsightsStr = "";
		for (int i = 0; i < conceptInsights.size(); i++) {
			conceptInsightsStr += "https://en.wikipedia.org/wiki/" 
					+ conceptInsights.get(i);
			
			if (i < conceptInsights.size() - 1) {
				
				conceptInsightsStr += "\n";
			}
		}
		
		return conceptInsightsStr;
	}
}
