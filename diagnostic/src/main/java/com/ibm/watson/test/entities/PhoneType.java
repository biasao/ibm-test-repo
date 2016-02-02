package com.ibm.watson.test.entities;

public enum PhoneType {
	WORK("crud.field.phone.type.work"), HOME("crud.field.phone.type.home"), MOBILE("crud.field.phone.type.mobile");

	private String bundleKey;
	
	PhoneType(String bundleKey) {
		this.bundleKey = bundleKey;
	}

	public String getBundleKey() {
		return bundleKey;
	}

	public void setBundleKey(String bundleKey) {
		this.bundleKey = bundleKey;
	}
}
