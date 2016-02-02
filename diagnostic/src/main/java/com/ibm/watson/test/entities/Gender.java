package com.ibm.watson.test.entities;

public enum Gender {
	FEMALE("female"), MALE("male");

	private String key;
	
	Gender(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
}
