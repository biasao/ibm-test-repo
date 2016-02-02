package com.ibm.watson.test.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ChildEvaluation {
	@Id
	@GeneratedValue
	private Long id;
	@Column(length=4000)
	private String generalObservation;
	@Column(length=100)
	private String consciousness;
	@Column(length=100)
	private String orientation;
	@Column(length=100)
	private String attention;
	@Column(length=100)
	private String memory;
	@Column(length=100)
	private String feltSense;
	@Column(length=100)
	private String thinking;
	@Column(length=100)
	private String language;
	@Column(length=100)
	private String humor;
	@Column(length=100)
	private String volition;
	@Column(length=100)
	private String psychomotor;
	@Column(length=100)
	private String intelligence;
	@Column(length=100)
	private String insight;
	@Column(length=100)
	private String diagnosis;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getGeneralObservation() {
		return generalObservation;
	}
	public void setGeneralObservation(String generalObservation) {
		this.generalObservation = generalObservation;
	}
	public String getConsciousness() {
		return consciousness;
	}
	public void setConsciousness(String consciousness) {
		this.consciousness = consciousness;
	}
	public String getOrientation() {
		return orientation;
	}
	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}
	public String getAttention() {
		return attention;
	}
	public void setAttention(String attention) {
		this.attention = attention;
	}
	public String getMemory() {
		return memory;
	}
	public void setMemory(String memory) {
		this.memory = memory;
	}
	public String getFeltSense() {
		return feltSense;
	}
	public void setFeltSense(String feltSense) {
		this.feltSense = feltSense;
	}
	public String getThinking() {
		return thinking;
	}
	public void setThinking(String thinking) {
		this.thinking = thinking;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getHumor() {
		return humor;
	}
	public void setHumor(String humor) {
		this.humor = humor;
	}
	public String getVolition() {
		return volition;
	}
	public void setVolition(String volition) {
		this.volition = volition;
	}
	public String getPsychomotor() {
		return psychomotor;
	}
	public void setPsychomotor(String psychomotor) {
		this.psychomotor = psychomotor;
	}
	public String getIntelligence() {
		return intelligence;
	}
	public void setIntelligence(String intelligence) {
		this.intelligence = intelligence;
	}
	public String getInsight() {
		return insight;
	}
	public void setInsight(String insight) {
		this.insight = insight;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
}
